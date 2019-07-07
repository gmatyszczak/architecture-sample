package pl.gmat.architecture.core.di

object Injector {

    lateinit var coreComponent: CoreComponent
        private set

    fun init(): CoreComponent {
        coreComponent = DaggerCoreComponent.create()
        return coreComponent
    }
}