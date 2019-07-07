package pl.gmat.architecture.core.feature

interface EffectHandler<E> {
    fun handle(effect: E)
}