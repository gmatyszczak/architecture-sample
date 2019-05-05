package pl.gmat.architecture.feature.main.effect

import pl.gmat.architecture.core.Effect
import pl.gmat.architecture.core.domain.Person

sealed class MainEffect : Effect() {
    data class ShowPersonDetails(val person: Person) : MainEffect()
}
