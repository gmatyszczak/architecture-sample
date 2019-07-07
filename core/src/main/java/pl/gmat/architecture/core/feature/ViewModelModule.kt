package pl.gmat.architecture.core.feature

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory = factory
}
