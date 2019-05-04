package pl.gmat.architecture.sample.feature.main.di

import dagger.BindsInstance
import dagger.Component
import pl.gmat.architecture.core.CoreComponent
import pl.gmat.architecture.core.FeatureScope
import pl.gmat.architecture.core.ViewModelModule
import pl.gmat.architecture.sample.feature.main.MainActivity

@FeatureScope
@Component(
    modules = [
        MainModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
interface MainComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance activity: MainActivity, coreComponent: CoreComponent): MainComponent
    }

    fun inject(screen: MainActivity)
}
