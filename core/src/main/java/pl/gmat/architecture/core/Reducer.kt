package pl.gmat.architecture.core

interface Reducer

interface BaseReducer<Action : Any, State, Effect> : Reducer {
    fun handle(state: State, action: Action): Pair<State, Effect>
}
