package pl.gmat.architecture.sample.feature.main.action.reducer

import arrow.core.Either
import org.junit.Assert.assertEquals
import org.junit.Test
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.action.reducer.LoadingFailedReducer

class LoadingFailedReducerTest {

    private val reducer = LoadingFailedReducer()

    @Test
    fun `on handle`() {
        assertEquals(Either.left(MainState()), reducer.handle(MainState(), MainAction.LoadingFailed))
    }
}