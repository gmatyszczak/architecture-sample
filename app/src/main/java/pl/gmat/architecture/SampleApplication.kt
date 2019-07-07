package pl.gmat.architecture

import android.app.Application
import pl.gmat.architecture.core.di.Injector

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.init()
    }
}