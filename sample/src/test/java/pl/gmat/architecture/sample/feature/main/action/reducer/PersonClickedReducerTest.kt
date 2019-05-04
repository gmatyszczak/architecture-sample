package pl.gmat.architecture.sample.feature.main.action.reducer

import arrow.core.Either
import org.junit.Assert.assertEquals
import org.junit.Test
import pl.gmat.architecture.sample.domain.Person
import pl.gmat.architecture.sample.feature.main.MainState
import pl.gmat.architecture.sample.feature.main.action.MainAction
import pl.gmat.architecture.sample.feature.main.effect.MainEffect

class PersonClickedReducerTest {

    private val reducer = PersonClickedReducer()

    @Test
    fun `on handle`() {
        assertEquals(
            Either.right(MainEffect.ShowPersonDetails(Person("name"))),
            reducer.handle(MainState(), MainAction.PersonClicked(Person("name")))
        )
    }
}