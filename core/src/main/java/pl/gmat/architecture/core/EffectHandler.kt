package pl.gmat.architecture.core

interface EffectHandler<E> {
    fun handle(effect: E)
}