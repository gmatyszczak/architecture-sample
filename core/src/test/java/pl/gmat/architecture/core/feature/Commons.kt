package pl.gmat.architecture.core.feature


data class TestState(val state: String)

object TestEffect

sealed class TestAction {
    object Reducer : TestAction()
    object Middleware : TestAction()
    object None : TestAction()
}
