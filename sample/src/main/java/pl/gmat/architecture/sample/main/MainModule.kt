package pl.gmat.architecture.sample.main

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.gmat.architecture.core.*

@Module
class MainModule {

    @ScreenScope
    @Provides
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun provideMainViewModel(viewModel: MainViewModel): ViewModel = viewModel

    @ScreenScope
    @Provides
    fun provideStore(
        middleware: MutableMap<Class<out Action>, Middleware>,
        reducers: MutableMap<Class<out Action>, Reducer>,
        initialState: MainState
    ) = Store<MainState, MainEffect>(middleware, reducers, initialState)

    @ScreenScope
    @Provides
    fun provideInitialState() = MainState()
}
