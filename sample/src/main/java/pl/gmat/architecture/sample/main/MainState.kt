package pl.gmat.architecture.sample.main

import pl.gmat.architecture.sample.domain.Person

data class MainState(val list: List<Person> = emptyList())
