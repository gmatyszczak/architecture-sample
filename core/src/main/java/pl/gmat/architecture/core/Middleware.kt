package pl.gmat.architecture.core

interface Middleware

interface BaseMiddleware<Action> : Middleware {
    fun handle(action: Action)
}