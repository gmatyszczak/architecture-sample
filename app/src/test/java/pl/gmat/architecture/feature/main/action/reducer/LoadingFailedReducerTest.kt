package pl.gmat.architecture.feature.main.action.reducer

import org.junit.Assert.assertEquals
import org.junit.Test
import pl.gmat.architecture.core.feature.Result
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.action.MainAction

class LoadingFailedReducerTest {

    private val reducer = LoadingFailedReducer()

    @Test
    fun `on handle`() {
        assertEquals(Result.State(MainState()), reducer.handle(MainState(), MainAction.LoadingFailed))
    }
}