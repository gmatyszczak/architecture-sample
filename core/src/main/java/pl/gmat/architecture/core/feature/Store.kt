package pl.gmat.architecture.core.feature

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Provider

interface Store<State, Effect, BaseAction> {

    val effect: LiveData<Effect>
    val state: LiveData<State>

    fun <A : BaseAction> dispatch(action: A)
}

class StoreImpl<State, Effect, BaseAction : Any>(
    initialState: State,
    private val reducers: MutableMap<Class<*>, Provider<Reducer<BaseAction, State, Effect>>>,
    private val middleware: MutableMap<Class<*>, Provider<Middleware<BaseAction>>>
) : Store<State, Effect, BaseAction> {

    override val effect = SingleLiveEvent<Effect>()
    override val state = MutableLiveData<State>()

    init {
        state.value = initialState
    }

    override fun <A : BaseAction> dispatch(action: A) {
        val middleware = middleware[action::class.java]
        if (middleware != null) {
            middleware.get().handle(action)
        } else {
            reducers[action::class.java]?.get()
                ?.handle(currentState, action)
                ?.fold({
                    state.value = it
                }, {
                    effect.value = it
                })
                ?: throw IllegalStateException("No reducer for $action")
        }
    }

    private val currentState = state.value ?: initialState
}