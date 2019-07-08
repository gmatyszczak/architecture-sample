package pl.gmat.architecture.core.feature

interface ActionDispatcher<BaseAction> {
    fun <A : BaseAction>dispatch(action: A)
}