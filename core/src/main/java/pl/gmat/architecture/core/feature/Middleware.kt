package pl.gmat.architecture.core.feature

interface Middleware<Action, BaseAction> {
    fun handle(action: Action, actionDispatcher: ActionDispatcher<BaseAction>)
}