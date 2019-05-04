package pl.gmat.architecture.sample.feature.main.action.reducer

import arrow.core.Either
import pl.gmat.architecture.core.Reducer
import pl.gmat.architecture.sample.feature.main.MainState
import pl.gmat.architecture.sample.feature.main.action.MainAction
import pl.gmat.architecture.sample.feature.main.effect.MainEffect
import javax.inject.Inject

class LoadingFailedReducer @Inject constructor() : Reducer<MainAction.LoadingFailed, MainState, MainEffect> {

    override fun handle(state: MainState, action: MainAction.LoadingFailed) = Either.left(MainState())
}