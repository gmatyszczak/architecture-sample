package pl.gmat.architecture.feature.details

import pl.gmat.architecture.core.feature.BaseViewModel
import pl.gmat.architecture.core.feature.CompositeDisposableFacade
import pl.gmat.architecture.core.feature.Reducer
import pl.gmat.architecture.feature.details.action.DetailsAction
import pl.gmat.architecture.feature.details.effect.DetailsEffect
import javax.inject.Inject
import javax.inject.Provider

class DetailsViewModel @Inject constructor(
    initialState: DetailsState,
    compositeDisposableFacade: CompositeDisposableFacade,
    reducers: MutableMap<Class<*>, Provider<Reducer<DetailsAction, DetailsState, DetailsEffect>>>
) : BaseViewModel<DetailsState, DetailsEffect, DetailsAction>(
    initialState,
    compositeDisposableFacade,
    reducers,
    mutableMapOf()
) {

    init {
        state.value = initialState
    }
}