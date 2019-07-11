package pl.gmat.architecture.feature.main.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import pl.gmat.architecture.core.di.BaseModule
import pl.gmat.architecture.core.feature.FeatureScope
import pl.gmat.architecture.core.feature.Middleware
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.action.middleware.LoadPeopleMiddleware

@Module
class MainMiddlewareModule : BaseModule<Middleware<MainAction>>() {

    @FeatureScope
    @Provides
    @IntoMap
    @ClassKey(MainAction.Init::class)
    fun provideLoadPeopleMiddleware(middleware: LoadPeopleMiddleware) = provide(middleware)
}