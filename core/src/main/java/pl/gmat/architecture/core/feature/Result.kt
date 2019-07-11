package pl.gmat.architecture.core.feature

sealed class Result<out State, out Effect> {

    fun fold(ifState: (State) -> Unit, ifEffect: (Effect) -> Unit) = when {
        this is Result.State -> ifState(value)
        this is Result.Effect -> ifEffect(value)
        else -> Unit
    }

    data class State<out S>(val value: S) : Result<S, Nothing>()
    data class Effect<out E>(val value: E) : Result<Nothing, E>()
}