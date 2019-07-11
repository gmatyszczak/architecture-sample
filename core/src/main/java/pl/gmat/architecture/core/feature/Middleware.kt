package pl.gmat.architecture.core.feature

interface Middleware<Action> {
    fun handle(action: Action)
}