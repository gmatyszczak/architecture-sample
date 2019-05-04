package pl.gmat.architecture.sample.feature.main.effect

import pl.gmat.architecture.core.Effect
import pl.gmat.architecture.sample.domain.Person

sealed class MainEffect : Effect() {
    data class ShowPersonDetails(val person: Person) : MainEffect()
}
