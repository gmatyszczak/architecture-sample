package pl.gmat.architecture.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<Action : Any, State, Effect>(
    private val store: Store<Action, State, Effect>
) : ViewModel() {

    val state: LiveData<State> = store.state
    val effect: LiveData<Effect> = store.effect

    fun onNewAction(action: Action) {
        store.dispatchAction(action)
    }
}