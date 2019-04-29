package pl.gmat.architecture.core

import androidx.lifecycle.MutableLiveData

abstract class Store<Action : Any, State, Effect>(
    private val middleware: MutableMap<Class<out Action>, Middleware<Action>>,
    private val reducers: MutableMap<Class<out Action>, Reducer<Action, State, Effect>>,
    private val initialState: State
) {

    val effect = MutableLiveData<Effect>()
    val state = MutableLiveData<State>()

    init {
        state.value = initialState
    }

    fun dispatchAction(action: Action) {
        val middleware = middleware[action::class.java]
        val reducer = reducers[action::class.java]
        when {
            middleware != null -> middleware.handle(action)
            reducer != null -> reducer.handle(state.value ?: initialState, action)
            else -> throw IllegalStateException("Action not handled!")
        }
    }
}
