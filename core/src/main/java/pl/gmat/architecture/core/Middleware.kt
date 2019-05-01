package pl.gmat.architecture.core

interface Middleware<Action, BaseAction> {
    fun handle(action: Action, actionDispatcher: ActionDispatcher<BaseAction>)
}