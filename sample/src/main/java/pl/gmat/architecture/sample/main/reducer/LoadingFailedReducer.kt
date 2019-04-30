package pl.gmat.architecture.sample.main.reducer

import arrow.core.Either
import pl.gmat.architecture.core.BaseReducer
import pl.gmat.architecture.sample.main.MainAction
import pl.gmat.architecture.sample.main.MainEffect
import pl.gmat.architecture.sample.main.MainState
import javax.inject.Inject

class LoadingFailedReducer @Inject constructor() : BaseReducer<MainAction.LoadingFailed, MainState, MainEffect> {

    override fun handle(state: MainState, action: MainAction.LoadingFailed) = Either.left(MainState())
}