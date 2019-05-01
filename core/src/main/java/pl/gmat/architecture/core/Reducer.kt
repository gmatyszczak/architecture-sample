package pl.gmat.architecture.core

import arrow.core.Either

interface Reducer<Action, State, Effect> {
    fun handle(state: State, action: Action): Either<State, Effect>
}
