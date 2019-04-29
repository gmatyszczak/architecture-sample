package pl.gmat.architecture.sample.main

sealed class MainAction {
    object LoadingFinished : MainAction()
    object ButtonClicked : MainAction()
}