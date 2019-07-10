package pl.gmat.architecture.feature.main.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.gmat.architecture.core.di.BaseModule
import pl.gmat.architecture.core.feature.EffectHandler
import pl.gmat.architecture.core.feature.EffectHandlerKey
import pl.gmat.architecture.core.feature.FeatureScope
import pl.gmat.architecture.feature.main.effect.MainEffect
import pl.gmat.architecture.feature.main.effect.handler.ShowPersonDetailsHandler

@Module
class MainEffectHandlerModule : BaseModule<EffectHandler<MainEffect>>() {

    @FeatureScope
    @Provides
    @IntoMap
    @EffectHandlerKey(MainEffect.ShowPersonDetails::class)
    fun provideShowPersonDetailsHandler(handler: ShowPersonDetailsHandler) = provide(handler)
}