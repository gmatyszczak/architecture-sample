package pl.gmat.architecture.sample.feature.main.reducer

import arrow.core.Either
import org.junit.Assert.assertEquals
import org.junit.Test
import pl.gmat.architecture.sample.feature.main.MainAction
import pl.gmat.architecture.sample.feature.main.MainState

class LoadingFailedReducerTest {

    private val reducer = LoadingFailedReducer()

    @Test
    fun `on handle`() {
        assertEquals(Either.left(MainState()), reducer.handle(MainState(), MainAction.LoadingFailed))
    }
}