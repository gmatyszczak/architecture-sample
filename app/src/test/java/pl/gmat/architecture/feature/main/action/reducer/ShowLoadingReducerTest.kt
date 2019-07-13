package pl.gmat.architecture.feature.main.action.reducer

import org.junit.Assert.assertEquals
import org.junit.Test
import pl.gmat.architecture.core.feature.Result
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.action.MainAction

class ShowLoadingReducerTest {

    private val reducer = ShowLoadingReducer()

    @Test
    fun `on handle`() {
        assertEquals(
            Result.State(MainState(isLoading = true)),
            reducer.handle(MainState(), MainAction.ShowLoading)
        )
    }
}