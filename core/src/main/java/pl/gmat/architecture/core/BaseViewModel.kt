package pl.gmat.architecture.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<State, Effect, BaseAction>(
    val initialState: State
) : ViewModel(), ActionDispatcher<BaseAction> {

    val effect = MutableLiveData<Effect>()
    val state = MutableLiveData<State>()

    protected inline fun <reified A> Middleware<A, BaseAction>.dispatch(action: BaseAction) =
        handle(action as A, this@BaseViewModel)

    protected inline fun <reified A> Reducer<A, State, Effect>.dispatch(action: BaseAction) =
        handle(state.value ?: initialState, action as A)
            .fold({
                state.value = it
            }, {
                effect.value = it
            })
}