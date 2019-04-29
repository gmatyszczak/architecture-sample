package pl.gmat.architecture.sample.main.reducer

import pl.gmat.architecture.core.Reducer
import pl.gmat.architecture.sample.main.MainAction
import pl.gmat.architecture.sample.main.MainEffect
import pl.gmat.architecture.sample.main.MainState
import javax.inject.Inject

class LoadingFinishedReducer @Inject constructor() : Reducer<MainAction, MainState, MainEffect> {

    override fun handle(state: MainState, action: MainAction): Pair<MainState, MainEffect> {
        return MainState() to MainEffect()
    }
}