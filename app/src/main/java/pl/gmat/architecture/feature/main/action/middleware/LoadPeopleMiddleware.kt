package pl.gmat.architecture.feature.main.action.middleware

import pl.gmat.architecture.core.feature.BaseMiddleware
import pl.gmat.architecture.core.feature.CompositeDisposableFacade
import pl.gmat.architecture.core.feature.Store
import pl.gmat.architecture.data.PeopleRepository
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.effect.MainEffect
import javax.inject.Inject

class LoadPeopleMiddleware @Inject constructor(
    private val peopleRepository: PeopleRepository,
    compositeDisposableFacade: CompositeDisposableFacade,
    private val store: Store<MainState, MainEffect, MainAction>
) : BaseMiddleware<MainAction.Init>(compositeDisposableFacade) {

    override fun handle(action: MainAction.Init) {
        peopleRepository.load()
            .subscribe({
                store.dispatch(MainAction.LoadingFinished(it))
            }, {
                store.dispatch(MainAction.LoadingFailed)
            }).addDisposable()
    }
}