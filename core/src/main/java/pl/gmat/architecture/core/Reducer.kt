package pl.gmat.architecture.core

import arrow.core.Either

interface Reducer

interface BaseReducer<Action : Any, State, Effect> : Reducer {
    fun handle(state: State, action: Action): Either<State, Effect>
}
