package pl.gmat.architecture.sample.domain

import io.reactivex.Single

interface PeopleRepository {

    fun load(): Single<List<Person>>
}