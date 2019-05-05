package pl.gmat.architecture.feature.main.action

import pl.gmat.architecture.core.domain.Person

sealed class MainAction {
    object Init : MainAction()
    object LoadingFailed : MainAction()
    data class LoadingFinished(val people: List<Person>) : MainAction()
    data class PersonClicked(val person: Person) : MainAction()
}