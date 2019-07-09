package pl.gmat.architecture.feature.main.action.reducer

import pl.gmat.architecture.core.feature.Reducer
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.effect.MainEffect
import javax.inject.Inject

class LoadingFinishedReducer @Inject constructor() :
    Reducer<MainAction.LoadingFinished, MainState, MainEffect> {

    override fun handle(state: MainState, action: MainAction.LoadingFinished) =
        Reducer.Result.State(MainState(action.people))
}