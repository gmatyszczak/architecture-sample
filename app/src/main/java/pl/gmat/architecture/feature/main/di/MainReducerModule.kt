package pl.gmat.architecture.feature.main.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.gmat.architecture.core.di.BaseModule
import pl.gmat.architecture.core.feature.FeatureScope
import pl.gmat.architecture.core.feature.Reducer
import pl.gmat.architecture.core.feature.ReducerKey
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.action.reducer.LoadingFailedReducer
import pl.gmat.architecture.feature.main.action.reducer.LoadingFinishedReducer
import pl.gmat.architecture.feature.main.action.reducer.PersonClickedReducer
import pl.gmat.architecture.feature.main.effect.MainEffect

@Module
class MainReducerModule : BaseModule<Reducer<MainAction, MainState, MainEffect>>() {

    @FeatureScope
    @Provides
    @IntoMap
    @ReducerKey(MainAction.LoadingFailed::class)
    fun provideLoadingFailedReducer(reducer: LoadingFailedReducer) = provide(reducer)

    @FeatureScope
    @Provides
    @IntoMap
    @ReducerKey(MainAction.LoadingFinished::class)
    fun provideLoadingFinishedReducer(reducer: LoadingFinishedReducer) = provide(reducer)

    @FeatureScope
    @Provides
    @IntoMap
    @ReducerKey(MainAction.PersonClicked::class)
    fun providePersonClickedReducer(reducer: PersonClickedReducer) = provide(reducer)
}