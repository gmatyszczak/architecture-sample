package pl.gmat.architecture.sample.feature.details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import pl.gmat.architecture.core.domain.Person
import pl.gmat.architecture.core.feature.CompositeDisposableFacade
import pl.gmat.architecture.feature.details.DetailsState
import pl.gmat.architecture.feature.details.DetailsViewModel

@RunWith(MockitoJUnitRunner::class)
class DetailsViewModelTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var stateObserver: Observer<DetailsState>

    @Mock
    private lateinit var compositeDisposableFacadeMock: CompositeDisposableFacade

    private val person = Person("name")
    private val initialState = DetailsState(person)
    private lateinit var viewModel: DetailsViewModel

    @Before
    fun setUp() {
        viewModel = DetailsViewModel(
            initialState,
            compositeDisposableFacadeMock,
            mutableMapOf()
        )
        viewModel.state.observeForever(stateObserver)
    }

    @Test
    fun `on init`() {
        verify(stateObserver).onChanged(DetailsState(person))
    }
}