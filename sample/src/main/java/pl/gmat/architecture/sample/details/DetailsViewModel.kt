package pl.gmat.architecture.sample.details

import pl.gmat.architecture.core.BaseViewModel
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    initialState: DetailsState
) : BaseViewModel<DetailsState, DetailsEffect, DetailsAction>(initialState) {
    
    override fun dispatch(action: DetailsAction) = Unit
}