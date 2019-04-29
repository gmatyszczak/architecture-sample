package pl.gmat.architecture.core

import android.app.Application

abstract class AppInjector<Component> {

    abstract var appComponent: Component
        protected set

    abstract fun initAppComponent(application: Application): Component
}
