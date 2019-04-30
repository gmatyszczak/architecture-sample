package pl.gmat.architecture.sample.main.reducer

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pl.gmat.architecture.core.ActionKey
import pl.gmat.architecture.core.Reducer
import pl.gmat.architecture.core.ScreenScope
import pl.gmat.architecture.sample.main.MainAction

@Module
abstract class MainReducerModule {

    @ScreenScope
    @Binds
    @IntoMap
    @ActionKey(MainAction.LoadingFinished::class)
    abstract fun provideLoadingFinishedReducer(reducer: LoadingFinishedReducer): Reducer

    @ScreenScope
    @Binds
    @IntoMap
    @ActionKey(MainAction.LoadingFailed::class)
    abstract fun provideLoadingFailedReducer(reducer: LoadingFailedReducer): Reducer
}
