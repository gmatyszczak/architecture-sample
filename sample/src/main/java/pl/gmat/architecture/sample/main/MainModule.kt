package pl.gmat.architecture.sample.main

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.gmat.architecture.core.Middleware
import pl.gmat.architecture.core.Reducer
import pl.gmat.architecture.core.ScreenScope
import pl.gmat.architecture.core.ViewModelKey
import pl.gmat.architecture.sample.main.middleware.ButtonClickedMiddleware
import pl.gmat.architecture.sample.main.reducer.LoadingFinishedReducer

@Module
class MainModule {

    @ScreenScope
    @Provides
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun provideMainViewModel(viewModel: MainViewModel): ViewModel = viewModel

    @ScreenScope
    @Provides
    @IntoMap
    @MainActionKey(MainAction.LoadingFinished::class)
    fun provideLoadingFinishedReducer(reducer: LoadingFinishedReducer): Reducer<MainAction, MainState, MainEffect> =
        reducer

    @ScreenScope
    @Provides
    @IntoMap
    @MainActionKey(MainAction.ButtonClicked::class)
    fun provideButtonClickedMiddleware(middleware: ButtonClickedMiddleware): Middleware<MainAction> = middleware

    @ScreenScope
    @Provides
    fun provideInitialState() = MainState()
}
