package pl.gmat.architecture.feature.details.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.gmat.architecture.core.di.BaseModule
import pl.gmat.architecture.core.feature.EffectHandler
import pl.gmat.architecture.core.feature.EffectHandlerKey
import pl.gmat.architecture.core.feature.FeatureScope
import pl.gmat.architecture.feature.details.effect.DetailsEffect
import pl.gmat.architecture.feature.details.effect.handler.FinishHandler

@Module
class DetailsEffectHandlerModule : BaseModule<EffectHandler<DetailsEffect>>() {

    @FeatureScope
    @Provides
    @IntoMap
    @EffectHandlerKey(DetailsEffect.Finish::class)
    fun provideFinishHandler(handler: FinishHandler) = provide(handler)
}