package pl.gmat.architecture.feature.details.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.gmat.architecture.core.feature.*
import pl.gmat.architecture.feature.details.DetailsActivity
import pl.gmat.architecture.feature.details.DetailsState
import pl.gmat.architecture.feature.details.DetailsViewModel
import pl.gmat.architecture.feature.details.action.DetailsAction
import pl.gmat.architecture.feature.details.effect.DetailsEffect
import javax.inject.Provider

@Module
class DetailsModule {

    @FeatureScope
    @Provides
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    fun provideDetailsViewModel(viewModel: DetailsViewModel): ViewModel = viewModel

    @FeatureScope
    @Provides
    fun provideStore(
        initialState: DetailsState,
        reducers: MutableMap<Class<*>, Provider<Reducer<DetailsAction, DetailsState, DetailsEffect>>>
    ): Store<DetailsState, DetailsEffect, DetailsAction> = StoreImpl(initialState, reducers, mutableMapOf())

    @FeatureScope
    @Provides
    fun provideInitialState(activity: DetailsActivity) =
        DetailsState(person = activity.intent.getParcelableExtra(DetailsActivity.EXTRA_PERSON))

    @FeatureScope
    @Provides
    fun provideActivity(activity: DetailsActivity): AppCompatActivity = activity
}
