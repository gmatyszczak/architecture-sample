package pl.gmat.architecture.core

import androidx.lifecycle.MutableLiveData

class Store<State, Effect>(
    val middleware: MutableMap<Class<out Action>, Middleware>,
    val reducers: MutableMap<Class<out Action>, Reducer>,
    val initialState: State
) {

    val effect = MutableLiveData<Effect>()
    val state = MutableLiveData<State>()

    init {
        state.value = initialState
        dispatchAction(Action.Init)
    }

    @Suppress("UNCHECKED_CAST")
    inline fun <reified A : Action> dispatchAction(action: A) {
        val middleware: Middleware? = middleware[A::class.java]
        val reducer = reducers[A::class.java]
        when {
            middleware != null -> (middleware as BaseMiddleware<A>).handle(action, this)
            reducer != null -> (reducer as BaseReducer<A, State, Effect>)
                .handle(state.value ?: initialState, action).fold({
                    state.value = it
                }, {
                    effect.value = it
                })
            else -> throw IllegalStateException("Action not handled!")
        }
    }
}
