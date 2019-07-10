package pl.gmat.architecture.feature.main.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.gmat.architecture.core.feature.FeatureScope
import pl.gmat.architecture.core.feature.ViewModelKey
import pl.gmat.architecture.data.PeopleRepository
import pl.gmat.architecture.data.PeopleRepositoryImpl
import pl.gmat.architecture.feature.main.MainActivity
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.MainViewModel

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
    fun provideActivity(activity: MainActivity): AppCompatActivity = activity
}
