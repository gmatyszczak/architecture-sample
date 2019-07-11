package pl.gmat.architecture.core.feature

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<State, Effect, BaseAction : Any>(
    private val store: Store<State, Effect, BaseAction>,
    private val compositeDisposableFacade: CompositeDisposableFacade
) : ViewModel() {

    val effect = store.effect
    val state = store.state

    fun dispatch(action: BaseAction) = store.dispatch(action)

    override fun onCleared() = compositeDisposableFacade.clear()
}