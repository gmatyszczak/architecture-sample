package pl.gmat.architecture.core.feature

interface ActionDispatcher<A> {
    fun dispatch(action: A)
}