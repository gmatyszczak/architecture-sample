package pl.gmat.architecture.sample.main

import pl.gmat.architecture.core.Action
import pl.gmat.architecture.sample.domain.Person

sealed class MainAction : Action.Feature() {
    data class LoadingFinished(val people: List<Person>) : MainAction()
}