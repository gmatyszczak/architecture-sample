package pl.gmat.architecture.sample.feature.details

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.gmat.architecture.core.ScreenScope
import pl.gmat.architecture.core.ViewModelKey

@Module
class DetailsModule {

    @ScreenScope
    @Provides
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    fun provideDetailsViewModel(viewModel: DetailsViewModel): ViewModel = viewModel

    @ScreenScope
    @Provides
    fun provideInitialState() = DetailsState()
}
