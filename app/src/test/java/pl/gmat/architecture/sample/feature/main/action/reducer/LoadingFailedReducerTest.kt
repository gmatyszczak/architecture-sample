package pl.gmat.architecture.sample.feature.main.action.reducer

import org.junit.Assert.assertEquals
import org.junit.Test
import pl.gmat.architecture.core.feature.Reducer
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.action.reducer.LoadingFailedReducer

class LoadingFailedReducerTest {

    private val reducer = LoadingFailedReducer()

    @Test
    fun `on handle`() {
        assertEquals(Reducer.Result.State(MainState()), reducer.handle(MainState(), MainAction.LoadingFailed))
    }
}