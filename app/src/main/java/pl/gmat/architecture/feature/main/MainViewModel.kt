package pl.gmat.architecture.feature.main

import pl.gmat.architecture.core.feature.BaseViewModel
import pl.gmat.architecture.core.feature.CompositeDisposableFacade
import pl.gmat.architecture.core.feature.Store
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.effect.MainEffect
import javax.inject.Inject

class MainViewModel @Inject constructor(
    store: Store<MainState, MainEffect, MainAction>,
    compositeDisposableFacade: CompositeDisposableFacade
) : BaseViewModel<MainState, MainEffect, MainAction>(store, compositeDisposableFacade) {

    init {
        store.dispatch(MainAction.Init)
    }
}