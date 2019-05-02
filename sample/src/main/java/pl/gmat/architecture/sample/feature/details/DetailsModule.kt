package pl.gmat.architecture.sample.feature.details

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.gmat.architecture.core.EffectHandler
import pl.gmat.architecture.core.Reducer
import pl.gmat.architecture.core.ScreenScope
import pl.gmat.architecture.core.ViewModelKey
import pl.gmat.architecture.sample.feature.details.handler.FinishHandler
import pl.gmat.architecture.sample.feature.details.reducer.FinishReducer

@Module
class DetailsModule {

    @ScreenScope
    @Provides
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    fun provideDetailsViewModel(viewModel: DetailsViewModel): ViewModel = viewModel

    @ScreenScope
    @Provides
    fun provideInitialState(activity: DetailsActivity) =
        DetailsState(person = activity.intent.getParcelableExtra(DetailsActivity.EXTRA_PERSON))

    @ScreenScope
    @Provides
    fun provideFinishReducer(reducer: FinishReducer): Reducer<DetailsAction.Finish, DetailsState, DetailsEffect> =
        reducer

    @ScreenScope
    @Provides
    fun provideFinishHandler(handler: FinishHandler): EffectHandler<DetailsEffect.Finish> = handler

    @ScreenScope
    @Provides
    fun provideActivity(activity: DetailsActivity): AppCompatActivity = activity
}
