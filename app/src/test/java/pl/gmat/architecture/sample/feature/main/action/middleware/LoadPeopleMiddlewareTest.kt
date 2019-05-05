package pl.gmat.architecture.sample.feature.main.action.middleware

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import pl.gmat.architecture.common.CompositeDisposableFacade
import pl.gmat.architecture.core.ActionDispatcher
import pl.gmat.architecture.core.domain.Person
import pl.gmat.architecture.data.PeopleRepository
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.action.middleware.LoadPeopleMiddleware

@RunWith(MockitoJUnitRunner::class)
class LoadPeopleMiddlewareTest {

    @Mock
    private lateinit var peopleRepositoryMock: PeopleRepository

    @Mock
    private lateinit var compositeDisposableFacadeMock: CompositeDisposableFacade

    @Mock
    private lateinit var actionDispatcherMock: ActionDispatcher<MainAction>

    @InjectMocks
    private lateinit var loadPeopleMiddleware: LoadPeopleMiddleware

    @Test
    fun `when repository call successful on handle`() {
        val people = listOf(Person("name"))
        whenever(peopleRepositoryMock.load()).thenReturn(Single.just(people))

        loadPeopleMiddleware.handle(MainAction.Init, actionDispatcherMock)
        verify(actionDispatcherMock).dispatch(MainAction.LoadingFinished(people))
        verify(compositeDisposableFacadeMock).add(any())
    }

    @Test
    fun `when repository call failed on handle`() {
        whenever(peopleRepositoryMock.load()).thenReturn(Single.error(Throwable()))

        loadPeopleMiddleware.handle(MainAction.Init, actionDispatcherMock)
        verify(actionDispatcherMock).dispatch(MainAction.LoadingFailed)
        verify(compositeDisposableFacadeMock).add(any())
    }

}