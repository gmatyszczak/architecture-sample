package pl.gmat.architecture.feature.details.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.gmat.architecture.core.feature.FeatureScope
import pl.gmat.architecture.core.feature.ViewModelKey
import pl.gmat.architecture.feature.details.DetailsActivity
import pl.gmat.architecture.feature.details.DetailsState
import pl.gmat.architecture.feature.details.DetailsViewModel

@Module
class DetailsModule {

    @FeatureScope
    @Provides
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    fun provideDetailsViewModel(viewModel: DetailsViewModel): ViewModel = viewModel

    @FeatureScope
    @Provides
    fun provideInitialState(activity: DetailsActivity) =
        DetailsState(person = activity.intent.getParcelableExtra(DetailsActivity.EXTRA_PERSON))

    @FeatureScope
    @Provides
    fun provideActivity(activity: DetailsActivity): AppCompatActivity = activity
}
