package pl.gmat.architecture.sample.feature.details.reducer

import org.junit.Assert.assertTrue
import org.junit.Test
import pl.gmat.architecture.sample.domain.Person
import pl.gmat.architecture.sample.feature.details.DetailsAction
import pl.gmat.architecture.sample.feature.details.DetailsEffect
import pl.gmat.architecture.sample.feature.details.DetailsState

class FinishReducerTest {

    private val reducer = FinishReducer()

    @Test
    fun `on handle`() {
        val result = reducer.handle(DetailsState(Person("")), DetailsAction.Finish)
        assertTrue(result.isRight())
        assertTrue(result.exists { it is DetailsEffect.Finish })
    }
}