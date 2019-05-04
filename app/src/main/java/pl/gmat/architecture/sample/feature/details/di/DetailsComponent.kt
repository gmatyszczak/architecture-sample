package pl.gmat.architecture.sample.feature.details.di

import dagger.BindsInstance
import dagger.Component
import pl.gmat.architecture.core.CoreComponent
import pl.gmat.architecture.core.FeatureScope
import pl.gmat.architecture.core.ViewModelModule
import pl.gmat.architecture.sample.feature.details.DetailsActivity

@FeatureScope
@Component(
    modules = [
        DetailsModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
interface DetailsComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance screen: DetailsActivity, coreComponent: CoreComponent): DetailsComponent
    }

    fun inject(screen: DetailsActivity)
}
