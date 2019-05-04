package pl.gmat.architecture.sample.data

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pl.gmat.architecture.sample.domain.PeopleRepository
import pl.gmat.architecture.sample.domain.Person
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(
    private val peopleService: PeopleService
) : PeopleRepository {

    override fun load(): Single<List<Person>> =
        peopleService.getPeople()
            .map { it.results }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}