package pl.gmat.architecture.sample.main.reducer

import arrow.core.Either
import pl.gmat.architecture.core.Reducer
import pl.gmat.architecture.sample.main.MainAction
import pl.gmat.architecture.sample.main.MainEffect
import pl.gmat.architecture.sample.main.MainState
import javax.inject.Inject

class PersonClickedReducer @Inject constructor() : Reducer<MainAction.PersonClicked, MainState, MainEffect> {

    override fun handle(state: MainState, action: MainAction.PersonClicked) = Either.right(MainEffect.ShowPersonDetails)
}