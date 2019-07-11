package pl.gmat.architecture.sample.feature.main

import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import pl.gmat.architecture.core.feature.CompositeDisposableFacade
import pl.gmat.architecture.core.feature.Store
import pl.gmat.architecture.feature.main.MainState
import pl.gmat.architecture.feature.main.MainViewModel
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.effect.MainEffect

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @Mock
    private lateinit var compositeDisposableFacadeMock: CompositeDisposableFacade

    @Mock
    private lateinit var storeMock: Store<MainState, MainEffect, MainAction>

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel(storeMock, compositeDisposableFacadeMock)
    }

    @Test
    fun `on init`() {
        verify(storeMock).dispatch(MainAction.Init)
    }
}