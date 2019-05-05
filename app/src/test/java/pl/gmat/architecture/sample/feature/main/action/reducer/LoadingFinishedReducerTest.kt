package pl.gmat.architecture.sample.feature.main.action.reducer

import arrow.core.Either
import org.junit.Assert.assertEquals
import org.junit.Test
import pl.gmat.architecture.core.domain.Person
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.action.reducer.LoadingFinishedReducer

class LoadingFinishedReducerTest {

    private val reducer = LoadingFinishedReducer()

    @Test
    fun `on handle`() {
        val people = listOf(Person("name"))
        assertEquals(Either.left(MainState(people)), reducer.handle(MainState(), MainAction.LoadingFinished(people)))
    }
}