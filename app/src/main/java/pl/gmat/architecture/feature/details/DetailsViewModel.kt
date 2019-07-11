package pl.gmat.architecture.feature.details

import pl.gmat.architecture.core.feature.BaseViewModel
import pl.gmat.architecture.core.feature.CompositeDisposableFacade
import pl.gmat.architecture.core.feature.Store
import pl.gmat.architecture.feature.details.action.DetailsAction
import pl.gmat.architecture.feature.details.effect.DetailsEffect
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    store: Store<DetailsState, DetailsEffect, DetailsAction>,
    compositeDisposableFacade: CompositeDisposableFacade
) : BaseViewModel<DetailsState, DetailsEffect, DetailsAction>(store, compositeDisposableFacade)