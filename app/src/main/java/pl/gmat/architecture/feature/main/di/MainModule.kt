package pl.gmat.architecture.feature.main.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.gmat.architecture.core.feature.*
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
    @IntoMap
    @MiddlewareKey(MainAction.Init::class)
    fun provideLoadPeopleMiddleware(middleware: LoadPeopleMiddleware): Middleware<MainAction, MainAction> =
        middleware as Middleware<MainAction, MainAction>

    @FeatureScope
    @Provides
    @IntoMap
    @ReducerKey(MainAction.LoadingFailed::class)
    fun provideLoadingFailedReducer(reducer: LoadingFailedReducer): Reducer<MainAction, MainState, MainEffect> =
        reducer as Reducer<MainAction, MainState, MainEffect>

    @FeatureScope
    @Provides
    @IntoMap
    @ReducerKey(MainAction.LoadingFinished::class)
    fun provideLoadingFinishedReducer(reducer: LoadingFinishedReducer): Reducer<MainAction, MainState, MainEffect> =
        reducer as Reducer<MainAction, MainState, MainEffect>

    @FeatureScope
    @Provides
    @IntoMap
    @ReducerKey(MainAction.PersonClicked::class)
    fun providePersonClickedReducer(reducer: PersonClickedReducer): Reducer<MainAction, MainState, MainEffect> =
        reducer as Reducer<MainAction, MainState, MainEffect>

    @FeatureScope
    @Provides
    fun provideShowPersonDetailsHandler(handler: ShowPersonDetailsHandler): EffectHandler<MainEffect.ShowPersonDetails> =
        handler

    @FeatureScope
    @Provides
    fun provideActivity(activity: MainActivity): AppCompatActivity = activity
}
