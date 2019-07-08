package pl.gmat.architecture.core.feature

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Provider

abstract class BaseViewModel<State, Effect, BaseAction : Any>(
    initialState: State,
    private val compositeDisposableFacade: CompositeDisposableFacade,
    private val reducers: MutableMap<Class<*>, Provider<Reducer<BaseAction, State, Effect>>>,
    private val middleware: MutableMap<Class<*>, Provider<Middleware<BaseAction, BaseAction>>>
) : ViewModel(), ActionDispatcher<BaseAction> {

    val effect = SingleLiveEvent<Effect>()
    val state = MutableLiveData<State>()

    override fun <A : BaseAction> dispatch(action: A) {
        val middleware = middleware[action::class.java]
        if (middleware != null) {
            middleware.get().handle(action, this)
        } else {
            reducers[action::class.java]?.get()
                ?.handle(currentState, action)
                ?.fold({
                    state.value = it
                }, {
                    effect.value = it
                })
        }
    }

    protected val currentState = state.value ?: initialState

    override fun onCleared() {
        compositeDisposableFacade.clear()
        super.onCleared()
    }
}