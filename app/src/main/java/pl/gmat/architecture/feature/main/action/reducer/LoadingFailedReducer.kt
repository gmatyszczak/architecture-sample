package pl.gmat.architecture.feature.main.action.reducer

import arrow.core.Either
import pl.gmat.architecture.core.feature.Reducer
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.effect.MainEffect
import javax.inject.Inject

class LoadingFailedReducer @Inject constructor() :
    Reducer<MainAction.LoadingFailed, MainState, MainEffect> {

    override fun handle(state: MainState, action: MainAction.LoadingFailed) = Either.left(
        MainState()
    )
}