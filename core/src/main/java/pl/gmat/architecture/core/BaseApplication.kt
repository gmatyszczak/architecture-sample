package pl.gmat.architecture.core

import android.app.Application

abstract class BaseApplication<Component> : Application() {

    protected abstract val appInjector: AppInjector<Component>

    protected abstract fun inject(component: Component)

    override fun onCreate() {
        super.onCreate()
        inject(appInjector.initAppComponent(this))
    }
}