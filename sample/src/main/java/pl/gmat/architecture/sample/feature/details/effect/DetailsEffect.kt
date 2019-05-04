package pl.gmat.architecture.sample.feature.details.effect

import pl.gmat.architecture.core.Effect

sealed class DetailsEffect : Effect() {
    class Finish : DetailsEffect()
}