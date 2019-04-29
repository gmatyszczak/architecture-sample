package pl.gmat.architecture.sample.main

import pl.gmat.architecture.core.BaseActivity
import pl.gmat.architecture.sample.R
import pl.gmat.architecture.sample.SampleAppInjector

class MainActivity : BaseActivity<MainViewModel, MainAction, MainState, MainEffect>() {

    override val layoutId = R.layout.activity_main

    override val viewModelClass = MainViewModel::class.java

    override fun inject() = SampleAppInjector.appComponent.mainComponentFactory().create(this).inject(this)
}