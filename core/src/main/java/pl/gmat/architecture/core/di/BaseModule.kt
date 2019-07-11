package pl.gmat.architecture.core.di

abstract class BaseModule<ComponentBase> {

    @Suppress("UNCHECKED_CAST")
    fun <Component> provide(component: Component): ComponentBase = component as ComponentBase
}