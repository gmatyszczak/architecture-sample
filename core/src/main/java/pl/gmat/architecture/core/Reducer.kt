package pl.gmat.architecture.core

interface Reducer<Action : Any, State, Effect> {
    fun handle(state: State, action: Action): Pair<State, Effect>
}
