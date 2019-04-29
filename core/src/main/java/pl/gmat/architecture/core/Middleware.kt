package pl.gmat.architecture.core

interface Middleware<Action> {
    fun handle(action: Action)
}
