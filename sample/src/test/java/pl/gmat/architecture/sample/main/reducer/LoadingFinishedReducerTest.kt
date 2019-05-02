package pl.gmat.architecture.sample.main.reducer

import arrow.core.Either
import org.junit.Assert.assertEquals
import org.junit.Test
import pl.gmat.architecture.sample.domain.Person
import pl.gmat.architecture.sample.main.MainAction
import pl.gmat.architecture.sample.main.MainState

class LoadingFinishedReducerTest {

    private val reducer = LoadingFinishedReducer()

    @Test
    fun `on handle`() {
        val people = listOf(Person("name"))
        assertEquals(Either.left(MainState(people)), reducer.handle(MainState(), MainAction.LoadingFinished(people)))
    }
}