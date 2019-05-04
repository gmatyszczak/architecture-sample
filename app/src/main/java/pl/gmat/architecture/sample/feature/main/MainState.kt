package pl.gmat.architecture.sample.feature.main

import pl.gmat.architecture.core.domain.Person

data class MainState(val list: List<Person> = emptyList())
