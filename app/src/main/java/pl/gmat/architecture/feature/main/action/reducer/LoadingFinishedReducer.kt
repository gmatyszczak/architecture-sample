package pl.gmat.architecture.feature.main.action.reducer

import arrow.core.Either
import pl.gmat.architecture.core.Reducer
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.effect.MainEffect
import javax.inject.Inject

class LoadingFinishedReducer @Inject constructor() : Reducer<MainAction.LoadingFinished, MainState, MainEffect> {

    override fun handle(state: MainState, action: MainAction.LoadingFinished) = Either.left(
        MainState(action.people)
    )
}