package pl.gmat.architecture.core

interface EffectHandler<E : Effect> {
    fun handle(effect: E)
}