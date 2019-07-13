package pl.gmat.architecture.feature.main.action.reducer

import org.junit.Assert.assertEquals
import org.junit.Test
import pl.gmat.architecture.core.domain.Person
import pl.gmat.architecture.core.feature.Result
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.effect.MainEffect

class PersonClickedReducerTest {

    private val reducer = PersonClickedReducer()

    @Test
    fun `on handle`() {
        assertEquals(
            Result.Effect(MainEffect.ShowPersonDetails(Person("name"))),
            reducer.handle(MainState(), MainAction.PersonClicked(Person("name")))
        )
    }
}