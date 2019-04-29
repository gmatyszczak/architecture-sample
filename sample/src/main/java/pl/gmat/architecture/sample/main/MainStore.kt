package pl.gmat.architecture.sample.main

import pl.gmat.architecture.core.Middleware
import pl.gmat.architecture.core.Reducer
import pl.gmat.architecture.core.ScreenScope
import pl.gmat.architecture.core.Store
import javax.inject.Inject

@ScreenScope
class MainStore @Inject constructor(
    middleware: MutableMap<Class<out MainAction>, Middleware<MainAction>>,
    reducers: MutableMap<Class<out MainAction>, Reducer<MainAction, MainState, MainEffect>>,
    initialState: MainState
) : Store<MainAction, MainState, MainEffect>(middleware, reducers, initialState)