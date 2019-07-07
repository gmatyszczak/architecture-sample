package pl.gmat.architecture.feature.main.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable
import pl.gmat.architecture.common.CompositeDisposableFacade
import pl.gmat.architecture.common.CompositeDisposableFacadeImpl
import pl.gmat.architecture.core.*
import pl.gmat.architecture.data.PeopleRepository
import pl.gmat.architecture.data.PeopleRepositoryImpl
import pl.gmat.architecture.feature.main.MainActivity
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.MainViewModel
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.action.middleware.LoadPeopleMiddleware
import pl.gmat.architecture.feature.main.action.reducer.LoadingFailedReducer
import pl.gmat.architecture.feature.main.action.reducer.LoadingFinishedReducer
import pl.gmat.architecture.feature.main.action.reducer.PersonClickedReducer
import pl.gmat.architecture.feature.main.effect.MainEffect
import pl.gmat.architecture.feature.main.effect.handler.ShowPersonDetailsHandler

@Module
class MainModule {

    @FeatureScope
    @Provides
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun provideMainViewModel(viewModel: MainViewModel): ViewModel = viewModel

    @FeatureScope
    @Provides
    fun provideInitialState() = MainState()

    @FeatureScope
    @Provides
    fun providePeopleRepository(repository: PeopleRepositoryImpl): PeopleRepository = repository

    @FeatureScope
    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

    @FeatureScope
    @Provides
    fun provideCompositeDisposableFacade(facade: CompositeDisposableFacadeImpl): CompositeDisposableFacade = facade

    @FeatureScope
    @Provides
    fun provideLoadPeopleMiddleware(middleware: LoadPeopleMiddleware): Middleware<MainAction.Init, MainAction> =
        middleware

    @FeatureScope
    @Provides
    fun provideLoadingFailedReducer(reducer: LoadingFailedReducer): Reducer<MainAction.LoadingFailed, MainState, MainEffect> =
        reducer

    @FeatureScope
    @Provides
    fun provideLoadingFinishedReducer(reducer: LoadingFinishedReducer): Reducer<MainAction.LoadingFinished, MainState, MainEffect> =
        reducer

    @FeatureScope
    @Provides
    fun providePersonClickedReducer(reducer: PersonClickedReducer): Reducer<MainAction.PersonClicked, MainState, MainEffect> =
        reducer

    @FeatureScope
    @Provides
    fun provideShowPersonDetailsHandler(handler: ShowPersonDetailsHandler): EffectHandler<MainEffect.ShowPersonDetails> =
        handler

    @FeatureScope
    @Provides
    fun provideActivity(activity: MainActivity): AppCompatActivity = activity
}