package pl.gmat.architecture.sample.feature.main

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable
import pl.gmat.architecture.core.Middleware
import pl.gmat.architecture.core.Reducer
import pl.gmat.architecture.core.ScreenScope
import pl.gmat.architecture.core.ViewModelKey
import pl.gmat.architecture.sample.common.CompositeDisposableFacade
import pl.gmat.architecture.sample.common.CompositeDisposableFacadeImpl
import pl.gmat.architecture.sample.data.PeopleRepositoryImpl
import pl.gmat.architecture.sample.domain.PeopleRepository
import pl.gmat.architecture.sample.feature.main.middleware.LoadPeopleMiddleware
import pl.gmat.architecture.sample.feature.main.reducer.LoadingFailedReducer
import pl.gmat.architecture.sample.feature.main.reducer.LoadingFinishedReducer
import pl.gmat.architecture.sample.feature.main.reducer.PersonClickedReducer

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
}
