package pl.gmat.architecture.sample.main

import pl.gmat.architecture.core.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    store: MainStore
) : BaseViewModel<MainAction, MainState, MainEffect>(store) {

}