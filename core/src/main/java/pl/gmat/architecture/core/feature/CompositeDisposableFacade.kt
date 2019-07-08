package pl.gmat.architecture.core.feature

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

interface CompositeDisposableFacade {

    fun clear()
    fun add(disposable: Disposable)
}

class CompositeDisposableFacadeImpl @Inject constructor(
    private val compositeDisposable: CompositeDisposable
) : CompositeDisposableFacade {

    override fun clear() = compositeDisposable.clear()

    override fun add(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}

