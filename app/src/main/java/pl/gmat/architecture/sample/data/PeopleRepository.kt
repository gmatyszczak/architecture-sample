package pl.gmat.architecture.sample.data

import io.reactivex.Single
import pl.gmat.architecture.core.domain.Person

interface PeopleRepository {

    fun load(): Single<List<Person>>
}