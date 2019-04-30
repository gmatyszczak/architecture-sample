package pl.gmat.architecture.core

interface Middleware

interface BaseMiddleware<A : Action> : Middleware {
    fun handle(action: A, store: Store<*, *>)
}