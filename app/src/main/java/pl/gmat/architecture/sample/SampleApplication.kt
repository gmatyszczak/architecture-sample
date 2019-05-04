package pl.gmat.architecture.sample

import android.app.Application
import pl.gmat.architecture.core.Injector

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.init()
    }
}