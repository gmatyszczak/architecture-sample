package pl.gmat.architecture.feature.main

import pl.gmat.architecture.core.domain.Person

data class MainState(val list: List<Person> = emptyList())
