package pl.gmat.architecture.feature.main.di

import dagger.BindsInstance
import dagger.Component
import pl.gmat.architecture.common.CompositeDisposableModule
import pl.gmat.architecture.core.di.CoreComponent
import pl.gmat.architecture.core.feature.FeatureScope
import pl.gmat.architecture.core.feature.ViewModelModule
import pl.gmat.architecture.feature.main.MainActivity

@FeatureScope
@Component(
    modules = [
        MainModule::class,
        MainReducerModule::class,
        MainMiddlewareModule::class,
        MainEffectHandlerModule::class,
        ViewModelModule::class,
        CompositeDisposableModule::class
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
