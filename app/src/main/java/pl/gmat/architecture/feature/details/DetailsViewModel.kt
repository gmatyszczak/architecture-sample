package pl.gmat.architecture.feature.details

import pl.gmat.architecture.core.BaseViewModel
import pl.gmat.architecture.core.Reducer
import pl.gmat.architecture.feature.details.action.DetailsAction
import pl.gmat.architecture.feature.details.effect.DetailsEffect
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    initialState: DetailsState,
    private val finishReducer: Reducer<DetailsAction.Finish, DetailsState, DetailsEffect>
) : BaseViewModel<DetailsState, DetailsEffect, DetailsAction>(initialState) {

    init {
        state.value = initialState
    }

    override fun dispatch(action: DetailsAction) = when(action) {
        DetailsAction.Finish -> finishReducer.dispatch(action)
    }
}