package pl.gmat.architecture.sample.main

import io.reactivex.disposables.CompositeDisposable
import pl.gmat.architecture.core.BaseViewModel
import pl.gmat.architecture.core.Middleware
import pl.gmat.architecture.core.Reducer
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val compositeDisposable: CompositeDisposable,
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
        compositeDisposable.clear()
        super.onCleared()
    }
}