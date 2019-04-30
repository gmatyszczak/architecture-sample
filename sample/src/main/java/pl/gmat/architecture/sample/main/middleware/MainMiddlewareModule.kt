package pl.gmat.architecture.sample.main.middleware

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.gmat.architecture.core.Action
import pl.gmat.architecture.core.ActionKey
import pl.gmat.architecture.core.Middleware
import pl.gmat.architecture.core.ScreenScope

@Module
class MainMiddlewareModule {

    @ScreenScope
    @Provides
    @IntoMap
    @ActionKey(Action.Init::class)
    fun provideButtonClickedMiddleware(middleware: InitMiddleware): Middleware = middleware
}
