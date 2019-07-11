package pl.gmat.architecture.core.feature

import io.reactivex.disposables.Disposable

abstract class BaseMiddleware<Action>(
    private val compositeDisposableFacade: CompositeDisposableFacade
) : Middleware<Action> {

    protected fun Disposable.addDisposable() = compositeDisposableFacade.add(this)
}