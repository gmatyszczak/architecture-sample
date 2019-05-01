package pl.gmat.architecture.sample.main

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable
import pl.gmat.architecture.core.ScreenScope
import pl.gmat.architecture.core.ViewModelKey
import pl.gmat.architecture.sample.data.PeopleRepositoryImpl
import pl.gmat.architecture.sample.domain.PeopleRepository

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
}
