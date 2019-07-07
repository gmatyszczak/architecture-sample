package pl.gmat.architecture.feature.details.di

import dagger.BindsInstance
import dagger.Component
import pl.gmat.architecture.core.di.CoreComponent
import pl.gmat.architecture.core.feature.FeatureScope
import pl.gmat.architecture.core.feature.ViewModelModule
import pl.gmat.architecture.feature.details.DetailsActivity

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
