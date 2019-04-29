package pl.gmat.architecture.sample

import android.app.Application
import pl.gmat.architecture.core.AppInjector

object SampleAppInjector : AppInjector<AppComponent>() {

    override lateinit var appComponent: AppComponent

    override fun initAppComponent(application: Application): AppComponent {
        appComponent = DaggerAppComponent.factory()
            .create(application)
        return appComponent
    }
}