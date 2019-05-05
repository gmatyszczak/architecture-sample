package pl.gmat.architecture.sample.feature.details.action.reducer

import org.junit.Assert.assertTrue
import org.junit.Test
import pl.gmat.architecture.core.domain.Person
import pl.gmat.architecture.feature.details.DetailsState
import pl.gmat.architecture.feature.details.action.DetailsAction
import pl.gmat.architecture.feature.details.action.reducer.FinishReducer
import pl.gmat.architecture.feature.details.effect.DetailsEffect

class FinishReducerTest {

    private val reducer = FinishReducer()

    @Test
    fun `on handle`() {
        val result = reducer.handle(DetailsState(Person("")), DetailsAction.Finish)
        assertTrue(result.isRight())
        assertTrue(result.exists { it is DetailsEffect.Finish })
    }
}