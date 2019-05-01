package pl.gmat.architecture.sample.main

import pl.gmat.architecture.sample.domain.Person

sealed class MainAction {
    object Init : MainAction()
    object LoadingFailed : MainAction()
    data class LoadingFinished(val people: List<Person>) : MainAction()
    data class PersonClicked(val person: Person) : MainAction()
}