package pl.gmat.architecture.feature.main

import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import pl.gmat.architecture.core.data.PeopleResponse
import pl.gmat.architecture.core.data.PeopleService
import pl.gmat.architecture.core.data.SchedulerProvider
import pl.gmat.architecture.core.domain.Person

@RunWith(MockitoJUnitRunner::class)
class PeopleRepositoryImplTest {

    @Mock
    private lateinit var serviceMock: PeopleService

    @Mock
    private lateinit var schedulerProviderMock: SchedulerProvider

    @InjectMocks
    private lateinit var repository: PeopleRepositoryImpl

    @Before
    fun setUp() {
        whenever(schedulerProviderMock.io()).thenReturn(Schedulers.trampoline())
        whenever(schedulerProviderMock.main()).thenReturn(Schedulers.trampoline())
    }

    @Test
    fun `when api call successful on load`() {
        val people = listOf(Person("test"))
        whenever(serviceMock.getPeople()).thenReturn(Single.just(PeopleResponse(people)))

        repository.load().test().assertValue(people)
    }

    @Test
    fun `when api call failed on load`() {
        val throwable = Throwable()
        whenever(serviceMock.getPeople()).thenReturn(Single.error(throwable))

        repository.load().test().assertError(throwable)
    }
}