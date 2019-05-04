package pl.gmat.architecture.sample.feature.main.di

import dagger.BindsInstance
import dagger.Subcomponent
import pl.gmat.architecture.core.ScreenScope
import pl.gmat.architecture.sample.feature.main.MainActivity

@ScreenScope
@Subcomponent(
    modules = [
        MainModule::class
    ]
)
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity: MainActivity): MainComponent
    }

    fun inject(screen: MainActivity)
}
