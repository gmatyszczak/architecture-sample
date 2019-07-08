package pl.gmat.architecture.common

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import pl.gmat.architecture.core.feature.CompositeDisposableFacade
import pl.gmat.architecture.core.feature.CompositeDisposableFacadeImpl
import pl.gmat.architecture.core.feature.FeatureScope

@Module
class CompositeDisposableModule {

    @FeatureScope
    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

    @FeatureScope
    @Provides
    fun provideCompositeDisposableFacade(facade: CompositeDisposableFacadeImpl): CompositeDisposableFacade = facade
}