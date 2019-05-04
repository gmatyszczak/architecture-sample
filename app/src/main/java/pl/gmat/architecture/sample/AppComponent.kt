package pl.gmat.architecture.sample

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import pl.gmat.architecture.core.ApplicationScope
import pl.gmat.architecture.core.ViewModelModule
import pl.gmat.architecture.sample.feature.details.di.DetailsComponent
import pl.gmat.architecture.sample.feature.main.di.MainComponent

@ApplicationScope
@Component(
    modules = [
        ViewModelModule::class,
        ApiModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    fun inject(application: SampleApplication)

    fun mainComponentFactory(): MainComponent.Factory
    fun detailsComponentFactory(): DetailsComponent.Factory
}
