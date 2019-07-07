package pl.gmat.architecture.feature.main.effect

import pl.gmat.architecture.core.domain.Person

sealed class MainEffect {
    data class ShowPersonDetails(val person: Person) : MainEffect()
}
