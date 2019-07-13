package pl.gmat.architecture.feature.main.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.gmat.architecture.core.feature.*
import pl.gmat.architecture.feature.main.*
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.effect.MainEffect
import javax.inject.Provider

@Module
class MainModule {

    @Provides
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun provideMainViewModel(viewModel: MainViewModel): ViewModel = viewModel

    @FeatureScope
    @Provides
    fun provideStore(
        initialState: MainState,
        reducers: MutableMap<Class<*>, Provider<Reducer<MainAction, MainState, MainEffect>>>,
        middleware: MutableMap<Class<*>, Provider<Middleware<MainAction>>>
    ): Store<MainState, MainEffect, MainAction> = StoreImpl(initialState, reducers, middleware)

    @FeatureScope
    @Provides
    fun provideInitialState() = MainState()

    @FeatureScope
    @Provides
    fun providePeopleRepository(repository: PeopleRepositoryImpl): PeopleRepository = repository

    @FeatureScope
    @Provides
    fun provideActivity(activity: MainActivity): AppCompatActivity = activity
}
