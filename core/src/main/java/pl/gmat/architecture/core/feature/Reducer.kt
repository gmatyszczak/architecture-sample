package pl.gmat.architecture.core.feature

interface Reducer<Action, State, Effect> {
    fun handle(state: State, action: Action): Result<State, Effect>
}