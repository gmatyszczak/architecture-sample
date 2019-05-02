package pl.gmat.architecture.sample.feature.main.reducer

import arrow.core.Either
import pl.gmat.architecture.core.Reducer
import pl.gmat.architecture.sample.feature.main.MainAction
import pl.gmat.architecture.sample.feature.main.MainEffect
import pl.gmat.architecture.sample.feature.main.MainState
import javax.inject.Inject

class LoadingFinishedReducer @Inject constructor() : Reducer<MainAction.LoadingFinished, MainState, MainEffect> {

    override fun handle(state: MainState, action: MainAction.LoadingFinished) = Either.left(MainState(action.people))
}