package pl.gmat.architecture.feature.main.action.middleware

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import pl.gmat.architecture.core.domain.Person
import pl.gmat.architecture.core.feature.CompositeDisposableFacade
import pl.gmat.architecture.core.feature.Store
import pl.gmat.architecture.data.PeopleRepository
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.effect.MainEffect

@RunWith(MockitoJUnitRunner::class)
class RefreshPeopleMiddlewareTest {

    @Mock
    private lateinit var peopleRepositoryMock: PeopleRepository

    @Mock
    private lateinit var compositeDisposableFacadeMock: CompositeDisposableFacade

    @Mock
    private lateinit var storeMock: Store<MainState, MainEffect, MainAction>

    @InjectMocks
    private lateinit var refreshPeopleMiddleware: RefreshPeopleMiddleware

    @Test
    fun `when repository call successful on handle`() {
        val people = listOf(Person("name"))
        whenever(peopleRepositoryMock.load()).thenReturn(Single.just(people))

        refreshPeopleMiddleware.handle(MainAction.SwipedToRefresh)

        verify(storeMock).dispatch(MainAction.LoadingFinished(people))
        verify(compositeDisposableFacadeMock).add(any())
    }

    @Test
    fun `when repository call failed on handle`() {
        whenever(peopleRepositoryMock.load()).thenReturn(Single.error(Throwable()))

        refreshPeopleMiddleware.handle(MainAction.SwipedToRefresh)

        verify(storeMock).dispatch(MainAction.LoadingFailed)
        verify(compositeDisposableFacadeMock).add(any())
    }

}