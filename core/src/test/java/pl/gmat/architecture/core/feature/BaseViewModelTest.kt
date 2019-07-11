package pl.gmat.architecture.core.feature

import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BaseViewModelTest {

    @Mock
    private lateinit var storeMock: Store<TestState, TestEffect, TestAction>

    @Mock
    private lateinit var compositeDisposableFacadeMock: CompositeDisposableFacade

    private lateinit var viewModel: BaseViewModel<TestState, TestEffect, TestAction>

    private val stateLiveData = MutableLiveData<TestState>()
    private val effectLiveData = SingleLiveEvent<TestEffect>()

    @Before
    fun setUp() {
        whenever(storeMock.state).thenReturn(stateLiveData)
        whenever(storeMock.effect).thenReturn(effectLiveData)
        viewModel =
            object : BaseViewModel<TestState, TestEffect, TestAction>(storeMock, compositeDisposableFacadeMock) {}
    }

    @Test
    fun `on init`() {
        assertEquals(stateLiveData, viewModel.state)
        assertEquals(effectLiveData, viewModel.effect)
    }

    @Test
    fun `on dispatch`() {
        viewModel.dispatch(TestAction.None)

        verify(storeMock).dispatch(TestAction.None)
    }
}