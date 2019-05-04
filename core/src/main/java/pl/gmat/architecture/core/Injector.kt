package pl.gmat.architecture.core

object Injector {

    lateinit var coreComponent: CoreComponent
        private set

    fun init(): CoreComponent {
        coreComponent = DaggerCoreComponent.create()
        return coreComponent
    }
}