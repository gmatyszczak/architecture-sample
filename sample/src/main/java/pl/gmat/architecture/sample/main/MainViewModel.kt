package pl.gmat.architecture.sample.main

import io.reactivex.disposables.CompositeDisposable
import pl.gmat.architecture.core.BaseViewModel
import pl.gmat.architecture.core.Store
import javax.inject.Inject

class MainViewModel @Inject constructor(
    store: Store<MainState, MainEffect>,
    private val compositeDisposable: CompositeDisposable
) : BaseViewModel<MainState, MainEffect>(store) {

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}