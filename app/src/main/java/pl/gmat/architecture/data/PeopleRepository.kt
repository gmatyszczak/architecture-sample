package pl.gmat.architecture.data

import io.reactivex.Single
import pl.gmat.architecture.core.domain.Person

interface PeopleRepository {

    fun load(): Single<List<Person>>
}