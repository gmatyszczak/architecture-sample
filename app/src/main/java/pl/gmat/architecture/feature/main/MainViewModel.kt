package pl.gmat.architecture.feature.main

import pl.gmat.architecture.common.CompositeDisposableFacade
import pl.gmat.architecture.core.feature.BaseViewModel
import pl.gmat.architecture.core.feature.Middleware
import pl.gmat.architecture.core.feature.Reducer
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.effect.MainEffect
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val compositeDisposableFacade: CompositeDisposableFacade,
    private val loadPeopleMiddleware: Middleware<MainAction.Init, MainAction>,
    private val loadingFinishedReducer: Reducer<MainAction.LoadingFinished, MainState, MainEffect>,
    private val loadingFailedReducer: Reducer<MainAction.LoadingFailed, MainState, MainEffect>,
    private val personClickedReducer: Reducer<MainAction.PersonClicked, MainState, MainEffect>,
    initialState: MainState
) : BaseViewModel<MainState, MainEffect, MainAction>(initialState) {

    init {
        dispatch(MainAction.Init)
    }

    override fun dispatch(action: MainAction) = when (action) {
        MainAction.Init -> loadPeopleMiddleware.dispatch(action)
        is MainAction.PersonClicked -> personClickedReducer.dispatch(action)
        is MainAction.LoadingFinished -> loadingFinishedReducer.dispatch(action)
        MainAction.LoadingFailed -> loadingFailedReducer.dispatch(action)
    }

    override fun onCleared() {
        compositeDisposableFacade.clear()
        super.onCleared()
    }
}