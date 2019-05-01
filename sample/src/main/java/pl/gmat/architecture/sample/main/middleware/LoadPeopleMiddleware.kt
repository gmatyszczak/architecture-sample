package pl.gmat.architecture.sample.main.middleware

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import pl.gmat.architecture.core.ActionDispatcher
import pl.gmat.architecture.core.Middleware
import pl.gmat.architecture.sample.domain.PeopleRepository
import pl.gmat.architecture.sample.main.MainAction
import javax.inject.Inject

class LoadPeopleMiddleware @Inject constructor(
    private val peopleRepository: PeopleRepository,
    private val compositeDisposable: CompositeDisposable
) : Middleware<MainAction.Init, MainAction> {

    override fun handle(action: MainAction.Init, actionDispatcher: ActionDispatcher<MainAction>) {
        peopleRepository.load()
            .subscribe({
                actionDispatcher.dispatch(MainAction.LoadingFinished(it))
            }, {
                actionDispatcher.dispatch(MainAction.LoadingFailed)
            }).addTo(compositeDisposable)
    }
}