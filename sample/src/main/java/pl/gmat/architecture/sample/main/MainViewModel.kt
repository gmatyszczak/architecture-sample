package pl.gmat.architecture.sample.main

import pl.gmat.architecture.core.BaseViewModel
import pl.gmat.architecture.core.Store
import javax.inject.Inject

class MainViewModel @Inject constructor(
    store: Store<MainState, MainEffect>
) : BaseViewModel<MainState, MainEffect>(store)