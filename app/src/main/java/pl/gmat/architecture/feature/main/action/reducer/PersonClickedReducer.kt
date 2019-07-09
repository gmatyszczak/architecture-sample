package pl.gmat.architecture.feature.main.action.reducer

import pl.gmat.architecture.core.feature.Reducer
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.effect.MainEffect
import javax.inject.Inject

class PersonClickedReducer @Inject constructor() :
    Reducer<MainAction.PersonClicked, MainState, MainEffect> {

    override fun handle(state: MainState, action: MainAction.PersonClicked) =
        Reducer.Result.Effect(MainEffect.ShowPersonDetails(action.person))
}