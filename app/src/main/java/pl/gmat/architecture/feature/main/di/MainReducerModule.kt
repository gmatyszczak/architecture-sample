package pl.gmat.architecture.feature.main.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import pl.gmat.architecture.core.di.BaseModule
import pl.gmat.architecture.core.feature.FeatureScope
import pl.gmat.architecture.core.feature.Reducer
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.action.reducer.LoadingFailedReducer
import pl.gmat.architecture.feature.main.action.reducer.LoadingFinishedReducer
import pl.gmat.architecture.feature.main.action.reducer.PersonClickedReducer
import pl.gmat.architecture.feature.main.action.reducer.ShowLoadingReducer
import pl.gmat.architecture.feature.main.effect.MainEffect

@Module
class MainReducerModule : BaseModule<Reducer<MainAction, MainState, MainEffect>>() {

    @FeatureScope
    @Provides
    @IntoMap
    @ClassKey(MainAction.LoadingFailed::class)
    fun provideLoadingFailedReducer(reducer: LoadingFailedReducer) = provide(reducer)

    @FeatureScope
    @Provides
    @IntoMap
    @ClassKey(MainAction.LoadingFinished::class)
    fun provideLoadingFinishedReducer(reducer: LoadingFinishedReducer) = provide(reducer)

    @FeatureScope
    @Provides
    @IntoMap
    @ClassKey(MainAction.PersonClicked::class)
    fun providePersonClickedReducer(reducer: PersonClickedReducer) = provide(reducer)

    @FeatureScope
    @Provides
    @IntoMap
    @ClassKey(MainAction.ShowLoading::class)
    fun provideShowLoadingReducer(reducer: ShowLoadingReducer) = provide(reducer)
}