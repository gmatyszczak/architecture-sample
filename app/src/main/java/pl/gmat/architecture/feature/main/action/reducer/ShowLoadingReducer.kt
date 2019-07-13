package pl.gmat.architecture.feature.main.action.reducer

import pl.gmat.architecture.core.feature.Reducer
import pl.gmat.architecture.core.feature.Result
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.effect.MainEffect
import javax.inject.Inject

class ShowLoadingReducer @Inject constructor() :
    Reducer<MainAction.ShowLoading, MainState, MainEffect> {

    override fun handle(state: MainState, action: MainAction.ShowLoading) = Result.State(state.copy(isLoading = true))
}