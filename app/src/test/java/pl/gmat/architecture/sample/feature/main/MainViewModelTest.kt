package pl.gmat.architecture.sample.feature.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import pl.gmat.architecture.core.feature.CompositeDisposableFacade
import pl.gmat.architecture.core.feature.Middleware
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.MainViewModel
import pl.gmat.architecture.feature.main.action.MainAction
import javax.inject.Provider

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var middlewareProviderMock: Provider<Middleware<MainAction, MainAction>>

    @Mock
    private lateinit var middlewareMock: Middleware<MainAction, MainAction>

    @Mock
    private lateinit var compositeDisposableFacadeMock: CompositeDisposableFacade

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        whenever(middlewareProviderMock.get()).thenReturn(middlewareMock)
        viewModel = MainViewModel(
            compositeDisposableFacadeMock,
            MainState(),
            mutableMapOf(),
            mutableMapOf(MainAction.Init::class.java to middlewareProviderMock)
        )
    }

    @Test
    fun `on init`() {
        verify(middlewareMock).handle(MainAction.Init, viewModel)
    }
}