package pl.gmat.architecture.sample.feature.main.middleware

import io.reactivex.disposables.Disposable
import pl.gmat.architecture.core.ActionDispatcher
import pl.gmat.architecture.core.Middleware
import pl.gmat.architecture.sample.common.CompositeDisposableFacade
import pl.gmat.architecture.sample.domain.PeopleRepository
import pl.gmat.architecture.sample.feature.main.MainAction
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