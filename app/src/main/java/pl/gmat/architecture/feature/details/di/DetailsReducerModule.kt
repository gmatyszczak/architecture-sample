package pl.gmat.architecture.feature.details.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import pl.gmat.architecture.core.di.BaseModule
import pl.gmat.architecture.core.feature.FeatureScope
import pl.gmat.architecture.core.feature.Reducer
import pl.gmat.architecture.feature.details.DetailsState
import pl.gmat.architecture.feature.details.action.DetailsAction
import pl.gmat.architecture.feature.details.action.reducer.FinishReducer
import pl.gmat.architecture.feature.details.effect.DetailsEffect

@Module
class DetailsReducerModule : BaseModule<Reducer<DetailsAction, DetailsState, DetailsEffect>>() {

    @FeatureScope
    @Provides
    @IntoMap
    @ClassKey(DetailsAction.Finish::class)
    fun provideFinishReducer(reducer: FinishReducer) = provide(reducer)
}