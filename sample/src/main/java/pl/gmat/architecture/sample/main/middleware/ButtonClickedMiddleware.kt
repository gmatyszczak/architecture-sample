package pl.gmat.architecture.sample.main.middleware

import pl.gmat.architecture.core.Middleware
import pl.gmat.architecture.sample.main.MainAction
import javax.inject.Inject

class ButtonClickedMiddleware @Inject constructor() : Middleware<MainAction> {

    override fun handle(action: MainAction) {
    }
}