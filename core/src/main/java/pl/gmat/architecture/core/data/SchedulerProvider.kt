package pl.gmat.architecture.core.data

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

interface SchedulerProvider {

    fun main(): Scheduler
    fun io(): Scheduler
}

class SchedulerProviderImpl @Inject constructor() : SchedulerProvider {

    override fun main(): Scheduler = AndroidSchedulers.mainThread()

    override fun io(): Scheduler = Schedulers.io()
}