package pl.gmat.architecture.sample.main.middleware

import pl.gmat.architecture.core.Action
import pl.gmat.architecture.core.BaseMiddleware
import javax.inject.Inject

class InitMiddleware @Inject constructor() : BaseMiddleware<Action.Init> {

    override fun handle(action: Action.Init) {
    }
}