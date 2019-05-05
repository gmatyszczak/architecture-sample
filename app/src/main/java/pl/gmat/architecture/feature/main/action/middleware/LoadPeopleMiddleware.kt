package pl.gmat.architecture.feature.main.action.middleware

import io.reactivex.disposables.Disposable
import pl.gmat.architecture.common.CompositeDisposableFacade
import pl.gmat.architecture.core.ActionDispatcher
import pl.gmat.architecture.core.Middleware
import pl.gmat.architecture.data.PeopleRepository
import pl.gmat.architecture.feature.main.action.MainAction
import javax.inject.Inject

class LoadPeopleMiddleware @Inject constructor(
    private val peopleRepository: PeopleRepository,
    private val compositeDisposableFacade: CompositeDisposableFacade
) : Middleware<MainAction.Init, MainAction> {

    override fun handle(action: MainAction.Init, actionDispatcher: ActionDispatcher<MainAction>) {
        peopleRepository.load()
            .subscribe({
                actionDispatcher.dispatch(MainAction.LoadingFinished(it))
            }, {
                actionDispatcher.dispatch(MainAction.LoadingFailed)
            }).addDisposable()
    }

    private fun Disposable.addDisposable() = compositeDisposableFacade.add(this)
}