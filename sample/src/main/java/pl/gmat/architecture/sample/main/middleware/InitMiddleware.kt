package pl.gmat.architecture.sample.main.middleware

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import pl.gmat.architecture.core.Action
import pl.gmat.architecture.core.BaseMiddleware
import pl.gmat.architecture.core.Store
import pl.gmat.architecture.sample.domain.PeopleRepository
import pl.gmat.architecture.sample.main.MainAction
import javax.inject.Inject

class InitMiddleware @Inject constructor(
    private val peopleRepository: PeopleRepository,
    private val compositeDisposable: CompositeDisposable
) : BaseMiddleware<Action.Init> {

    override fun handle(action: Action.Init, store: Store<*, *>) {
        peopleRepository.load()
            .subscribe({
                store.dispatchAction(MainAction.LoadingFinished(it))
            }, {
                store.dispatchAction(MainAction.LoadingFailed)
            }
            ).addTo(compositeDisposable)
    }
}