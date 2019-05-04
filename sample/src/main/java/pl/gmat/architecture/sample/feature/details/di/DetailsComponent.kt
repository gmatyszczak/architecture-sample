package pl.gmat.architecture.sample.feature.details.di

import dagger.BindsInstance
import dagger.Subcomponent
import pl.gmat.architecture.core.ScreenScope
import pl.gmat.architecture.sample.feature.details.DetailsActivity

@ScreenScope
@Subcomponent(modules = [DetailsModule::class])
interface DetailsComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance screen: DetailsActivity): DetailsComponent
    }
    
    fun inject(screen: DetailsActivity)
}
