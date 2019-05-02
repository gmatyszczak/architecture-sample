package pl.gmat.architecture.sample.details

import dagger.BindsInstance
import dagger.Subcomponent
import pl.gmat.architecture.core.ScreenScope

@ScreenScope
@Subcomponent(modules = [DetailsModule::class])
interface DetailsComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance screen: DetailsActivity): DetailsComponent
    }
    
    fun inject(screen: DetailsActivity)
}
