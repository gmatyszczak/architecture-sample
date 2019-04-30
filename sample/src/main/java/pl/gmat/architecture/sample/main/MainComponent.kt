package pl.gmat.architecture.sample.main

import dagger.BindsInstance
import dagger.Subcomponent
import pl.gmat.architecture.core.ScreenScope
import pl.gmat.architecture.sample.main.middleware.MainMiddlewareModule
import pl.gmat.architecture.sample.main.reducer.MainReducerModule

@ScreenScope
@Subcomponent(
    modules = [
        MainModule::class,
        MainMiddlewareModule::class,
        MainReducerModule::class
    ]
)
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity: MainActivity): MainComponent
    }

    fun inject(screen: MainActivity)
}
