package pl.gmat.architecture.feature.main.action.middleware

import pl.gmat.architecture.core.feature.BaseMiddleware
import pl.gmat.architecture.core.feature.CompositeDisposableFacade
import pl.gmat.architecture.core.feature.Store
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.PeopleRepository
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.effect.MainEffect
import javax.inject.Inject

class RefreshPeopleMiddleware @Inject constructor(
    private val peopleRepository: PeopleRepository,
    compositeDisposableFacade: CompositeDisposableFacade,
    private val store: Store<MainState, MainEffect, MainAction>
) : BaseMiddleware<MainAction.SwipedToRefresh>(compositeDisposableFacade) {

    override fun handle(action: MainAction.SwipedToRefresh) {
        peopleRepository.load()
            .subscribe({
                store.dispatch(MainAction.LoadingFinished(it))
            }, {
                store.dispatch(MainAction.LoadingFailed)
            }).addDisposable()
    }

}
