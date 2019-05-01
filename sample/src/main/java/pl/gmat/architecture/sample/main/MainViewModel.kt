package pl.gmat.architecture.sample.main

import io.reactivex.disposables.CompositeDisposable
import pl.gmat.architecture.core.BaseViewModel
import pl.gmat.architecture.sample.main.middleware.LoadPeopleMiddleware
import pl.gmat.architecture.sample.main.reducer.LoadingFailedReducer
import pl.gmat.architecture.sample.main.reducer.LoadingFinishedReducer
import pl.gmat.architecture.sample.main.reducer.PersonClickedReducer
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val compositeDisposable: CompositeDisposable,
    private val loadPeopleMiddleware: LoadPeopleMiddleware,
    private val loadingFinishedReducer: LoadingFinishedReducer,
    private val loadingFailedReducer: LoadingFailedReducer,
    private val personClickedReducer: PersonClickedReducer,
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