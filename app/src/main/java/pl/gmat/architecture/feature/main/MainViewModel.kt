package pl.gmat.architecture.feature.main

import pl.gmat.architecture.core.feature.BaseViewModel
import pl.gmat.architecture.core.feature.CompositeDisposableFacade
import pl.gmat.architecture.core.feature.Middleware
import pl.gmat.architecture.core.feature.Reducer
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.effect.MainEffect
import javax.inject.Inject
import javax.inject.Provider

class MainViewModel @Inject constructor(
    private val compositeDisposableFacade: CompositeDisposableFacade,
    initialState: MainState,
    reducers: MutableMap<Class<*>, Provider<Reducer<MainAction, MainState, MainEffect>>>,
    middleware: MutableMap<Class<*>, Provider<Middleware<MainAction, MainAction>>>
) : BaseViewModel<MainState, MainEffect, MainAction>(initialState, compositeDisposableFacade, reducers, middleware) {

    init {
        dispatch(MainAction.Init)
    }

    override fun onCleared() {
        compositeDisposableFacade.clear()
        super.onCleared()
    }
}