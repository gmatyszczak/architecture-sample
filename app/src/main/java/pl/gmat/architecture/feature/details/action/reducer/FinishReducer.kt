package pl.gmat.architecture.feature.details.action.reducer

import arrow.core.Either
import pl.gmat.architecture.core.Reducer
import pl.gmat.architecture.feature.details.DetailsState
import pl.gmat.architecture.feature.details.action.DetailsAction
import pl.gmat.architecture.feature.details.effect.DetailsEffect
import javax.inject.Inject

class FinishReducer @Inject constructor() : Reducer<DetailsAction.Finish, DetailsState, DetailsEffect> {

    override fun handle(state: DetailsState, action: DetailsAction.Finish) = Either.right(
        DetailsEffect.Finish
    )
}
