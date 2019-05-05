package pl.gmat.architecture.sample.feature.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
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
import pl.gmat.architecture.common.CompositeDisposableFacade
import pl.gmat.architecture.core.Middleware
import pl.gmat.architecture.core.Reducer
import pl.gmat.architecture.core.domain.Person
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.MainViewModel
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.effect.MainEffect

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var loadPeopleMiddlewareMock: Middleware<MainAction.Init, MainAction>

    @Mock
    private lateinit var loadingFinishedReducerMock: Reducer<MainAction.LoadingFinished, MainState, MainEffect>

    @Mock
    private lateinit var loadingFailedReducerMock: Reducer<MainAction.LoadingFailed, MainState, MainEffect>

    @Mock
    private lateinit var personClickedReducerMock: Reducer<MainAction.PersonClicked, MainState, MainEffect>

    @Mock
    private lateinit var compositeDisposableFacadeMock: CompositeDisposableFacade

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel(
            compositeDisposableFacadeMock,
            loadPeopleMiddlewareMock,
            loadingFinishedReducerMock,
            loadingFailedReducerMock,
            personClickedReducerMock,
            MainState()
        )
    }

    @Test
    fun `on Init action`() {
        verify(loadPeopleMiddlewareMock).handle(MainAction.Init, viewModel)
    }

    @Test
    fun `on person clicked action`() {
        val person = Person("name")
        whenever(personClickedReducerMock.handle(MainState(), MainAction.PersonClicked(person))).thenReturn(
            Either.left(
                MainState()
            )
        )
        viewModel.dispatch(MainAction.PersonClicked(person))

        verify(personClickedReducerMock).handle(MainState(), MainAction.PersonClicked(person))
    }

    @Test
    fun `on person loading finished action`() {
        val people = listOf(Person("name"))
        whenever(loadingFinishedReducerMock.handle(MainState(), MainAction.LoadingFinished(people))).thenReturn(
            Either.left(
                MainState()
            )
        )
        viewModel.dispatch(MainAction.LoadingFinished(people))

        verify(loadingFinishedReducerMock).handle(MainState(), MainAction.LoadingFinished(people))
    }

    @Test
    fun `on person loading failed action`() {
        whenever(loadingFailedReducerMock.handle(MainState(), MainAction.LoadingFailed)).thenReturn(
            Either.left(
                MainState()
            )
        )
        viewModel.dispatch(MainAction.LoadingFailed)

        verify(loadingFailedReducerMock).handle(MainState(), MainAction.LoadingFailed)
    }
}