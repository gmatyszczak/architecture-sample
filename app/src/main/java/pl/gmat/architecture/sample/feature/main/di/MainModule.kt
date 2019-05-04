package pl.gmat.architecture.sample.feature.main.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable
import pl.gmat.architecture.core.*
import pl.gmat.architecture.sample.common.CompositeDisposableFacade
import pl.gmat.architecture.sample.common.CompositeDisposableFacadeImpl
import pl.gmat.architecture.sample.data.PeopleRepositoryImpl
import pl.gmat.architecture.sample.domain.PeopleRepository
import pl.gmat.architecture.sample.feature.main.MainActivity
import pl.gmat.architecture.sample.feature.main.MainState
import pl.gmat.architecture.sample.feature.main.MainViewModel
import pl.gmat.architecture.sample.feature.main.action.MainAction
import pl.gmat.architecture.sample.feature.main.action.middleware.LoadPeopleMiddleware
import pl.gmat.architecture.sample.feature.main.action.reducer.LoadingFailedReducer
import pl.gmat.architecture.sample.feature.main.action.reducer.LoadingFinishedReducer
import pl.gmat.architecture.sample.feature.main.action.reducer.PersonClickedReducer
import pl.gmat.architecture.sample.feature.main.effect.MainEffect
import pl.gmat.architecture.sample.feature.main.effect.handler.ShowPersonDetailsHandler

@Module
class MainModule {

    @ScreenScope
    @Provides
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun provideMainViewModel(viewModel: MainViewModel): ViewModel = viewModel

    @ScreenScope
    @Provides
    fun provideInitialState() = MainState()

    @ScreenScope
    @Provides
    fun providePeopleRepository(repository: PeopleRepositoryImpl): PeopleRepository = repository

    @ScreenScope
    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

    @ScreenScope
    @Provides
    fun provideCompositeDisposableFacade(facade: CompositeDisposableFacadeImpl): CompositeDisposableFacade = facade

    @ScreenScope
    @Provides
    fun provideLoadPeopleMiddleware(middleware: LoadPeopleMiddleware): Middleware<MainAction.Init, MainAction> =
        middleware

    @ScreenScope
    @Provides
    fun provideLoadingFailedReducer(reducer: LoadingFailedReducer): Reducer<MainAction.LoadingFailed, MainState, MainEffect> =
        reducer

    @ScreenScope
    @Provides
    fun provideLoadingFinishedReducer(reducer: LoadingFinishedReducer): Reducer<MainAction.LoadingFinished, MainState, MainEffect> =
        reducer

    @ScreenScope
    @Provides
    fun providePersonClickedReducer(reducer: PersonClickedReducer): Reducer<MainAction.PersonClicked, MainState, MainEffect> =
        reducer

    @ScreenScope
    @Provides
    fun provideShowPersonDetailsHandler(handler: ShowPersonDetailsHandler): EffectHandler<MainEffect.ShowPersonDetails> =
        handler

    @ScreenScope
    @Provides
    fun provideActivity(activity: MainActivity): AppCompatActivity = activity
}
