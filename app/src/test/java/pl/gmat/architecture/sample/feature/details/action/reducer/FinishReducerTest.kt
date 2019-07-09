package pl.gmat.architecture.sample.feature.details.action.reducer

import org.junit.Assert.assertEquals
import org.junit.Test
import pl.gmat.architecture.core.domain.Person
import pl.gmat.architecture.core.feature.Reducer
import pl.gmat.architecture.feature.details.DetailsState
import pl.gmat.architecture.feature.details.action.DetailsAction
import pl.gmat.architecture.feature.details.action.reducer.FinishReducer
import pl.gmat.architecture.feature.details.effect.DetailsEffect

class FinishReducerTest {

    private val reducer = FinishReducer()

    @Test
    fun `on handle`() {
        assertEquals(
            Reducer.Result.Effect(DetailsEffect.Finish),
            reducer.handle(DetailsState(Person("")), DetailsAction.Finish)
        )
    }
}