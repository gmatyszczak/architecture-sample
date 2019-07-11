package pl.gmat.architecture.core.feature

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import javax.inject.Provider

@RunWith(MockitoJUnitRunner::class)
class StoreImplTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var reducerProviderMock: Provider<Reducer<TestAction, TestState, TestEffect>>

    @Mock
    private lateinit var middlewareProviderMock: Provider<Middleware<TestAction>>

    @Mock
    private lateinit var reducerMock: Reducer<TestAction, TestState, TestEffect>

    @Mock
    private lateinit var middlewareMock: Middleware<TestAction>

    @Mock
    private lateinit var stateObserver: Observer<TestState>

    @Mock
    private lateinit var effectObserver: Observer<TestEffect>

    private val initialState = TestState("initial")

    private lateinit var store: StoreImpl<TestState, TestEffect, TestAction>

    @Before
    fun setUp() {
        val reducers = mutableMapOf<Class<*>, Provider<Reducer<TestAction, TestState, TestEffect>>>(
            TestAction.Reducer::class.java to reducerProviderMock
        )
        val middleware = mutableMapOf<Class<*>, Provider<Middleware<TestAction>>>(
            TestAction.Middleware::class.java to middlewareProviderMock
        )
        store = StoreImpl(TestState("initial"), reducers, middleware)
        store.state.observeForever(stateObserver)
        store.effect.observeForever(effectObserver)
    }

    @Test
    fun `on init`() {
        verify(stateObserver).onChanged(initialState)
    }

    @Test
    fun `should handle middleware on dispatch`() {
        whenever(middlewareProviderMock.get()).thenReturn(middlewareMock)

        store.dispatch(TestAction.Middleware)

        verify(middlewareMock).handle(TestAction.Middleware)
    }

    @Test
    fun `should handle reducer and result state on dispatch`() {
        whenever(reducerProviderMock.get()).thenReturn(reducerMock)
        val newState = TestState("test")
        whenever(
            reducerMock.handle(
                initialState,
                TestAction.Reducer
            )
        ).thenReturn(Result.State(newState))

        store.dispatch(TestAction.Reducer)

        verify(stateObserver).onChanged(newState)
    }

    @Test
    fun `should handle reducer and result effect on dispatch`() {
        whenever(reducerProviderMock.get()).thenReturn(reducerMock)
        whenever(
            reducerMock.handle(
                initialState,
                TestAction.Reducer
            )
        ).thenReturn(Result.Effect(TestEffect))

        store.dispatch(TestAction.Reducer)

        verify(effectObserver).onChanged(TestEffect)
    }

    @Test(expected = IllegalStateException::class)
    fun `when no reducer on dispatch`() {
        store.dispatch(TestAction.None)
    }
}