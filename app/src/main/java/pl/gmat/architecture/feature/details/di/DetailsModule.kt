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
import pl.gmat.architecture.feature.details.action.reducer.FinishReducer
import pl.gmat.architecture.feature.details.effect.DetailsEffect
import pl.gmat.architecture.feature.details.effect.handler.FinishHandler

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
    @IntoMap
    @ReducerKey(DetailsAction.Finish::class)
    fun provideFinishReducer(reducer: FinishReducer): Reducer<DetailsAction, DetailsState, DetailsEffect> =
        reducer as Reducer<DetailsAction, DetailsState, DetailsEffect>

    @FeatureScope
    @Provides
    @IntoMap
    @EffectHandlerKey(DetailsEffect.Finish::class)
    fun provideFinishHandler(handler: FinishHandler): EffectHandler<DetailsEffect> =
        handler as EffectHandler<DetailsEffect>

    @FeatureScope
    @Provides
    fun provideActivity(activity: DetailsActivity): AppCompatActivity = activity
}
