package pl.gmat.architecture.core.di

abstract class BaseModule<ComponentBase> {

    fun <Component> provide(component: Component): ComponentBase = component as ComponentBase
}