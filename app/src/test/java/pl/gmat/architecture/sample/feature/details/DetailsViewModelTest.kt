package pl.gmat.architecture.sample.feature.details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import arrow.core.Either
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import pl.gmat.architecture.core.Reducer
import pl.gmat.architecture.core.domain.Person
import pl.gmat.architecture.feature.details.DetailsState
import pl.gmat.architecture.feature.details.DetailsViewModel
import pl.gmat.architecture.feature.details.action.DetailsAction
import pl.gmat.architecture.feature.details.effect.DetailsEffect

@RunWith(MockitoJUnitRunner::class)
class DetailsViewModelTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var stateObserver: Observer<DetailsState>

    @Mock
    private lateinit var finishReducerMock: Reducer<DetailsAction.Finish, DetailsState, DetailsEffect>

    private val person = Person("name")
    private val initialState = DetailsState(person)
    private lateinit var viewModel: DetailsViewModel

    @Before
    fun setUp() {
        viewModel = DetailsViewModel(
            DetailsState(person), finishReducerMock
        )
        viewModel.state.observeForever(stateObserver)
    }

    @Test
    fun `on init`() {
        verify(stateObserver).onChanged(DetailsState(person))
    }

    @Test
    fun `on finish action`() {
        whenever(
            finishReducerMock.handle(
                initialState,
                DetailsAction.Finish
            )
        ).thenReturn(Either.right(DetailsEffect.Finish))

        viewModel.dispatch(DetailsAction.Finish)
        verify(finishReducerMock).handle(initialState, DetailsAction.Finish)
    }

}