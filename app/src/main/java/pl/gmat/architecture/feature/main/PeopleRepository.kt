package pl.gmat.architecture.feature.main

import io.reactivex.Single
import pl.gmat.architecture.core.data.PeopleService
import pl.gmat.architecture.core.data.SchedulerProvider
import pl.gmat.architecture.core.domain.Person
import javax.inject.Inject

interface PeopleRepository {

    fun load(): Single<List<Person>>
}

class PeopleRepositoryImpl @Inject constructor(
    private val peopleService: PeopleService,
    private val schedulerProvider: SchedulerProvider
) : PeopleRepository {

    override fun load(): Single<List<Person>> =
        peopleService.getPeople()
            .map { it.results }
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.main())
}