package pl.gmat.architecture.sample

import pl.gmat.architecture.core.BaseApplication

class SampleApplication : BaseApplication<AppComponent>() {

    override val appInjector = SampleAppInjector

    override fun inject(component: AppComponent) = component.inject(this)
}