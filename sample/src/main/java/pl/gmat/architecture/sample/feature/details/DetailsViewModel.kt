package pl.gmat.architecture.sample.feature.details

import pl.gmat.architecture.core.BaseViewModel
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    initialState: DetailsState
) : BaseViewModel<DetailsState, DetailsEffect, DetailsAction>(initialState) {

    init {
        state.value = initialState
    }

    override fun dispatch(action: DetailsAction) = Unit
}