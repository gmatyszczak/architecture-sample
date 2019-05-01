package pl.gmat.architecture.core

interface ActionDispatcher<A> {
    fun dispatch(action: A)
}