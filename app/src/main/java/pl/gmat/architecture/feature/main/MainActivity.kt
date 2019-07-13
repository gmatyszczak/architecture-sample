package pl.gmat.architecture.feature.main

import androidx.recyclerview.widget.LinearLayoutManager
import pl.gmat.architecture.core.di.Injector
import pl.gmat.architecture.core.feature.BaseActivity
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.di.DaggerMainComponent
import pl.gmat.architecture.feature.main.effect.MainEffect
import pl.gmat.architecture.feature.main.widget.PeopleAdapter
import pl.gmat.architecture.sample.R
import pl.gmat.architecture.sample.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel, MainState, MainEffect, MainAction>() {

    override val layoutId = R.layout.activity_main

    override val viewModelClass = MainViewModel::class.java

    private lateinit var peopleAdapter: PeopleAdapter

    override fun inject() = DaggerMainComponent.factory().create(this, Injector.coreComponent).inject(this)

    override fun ActivityMainBinding.observeState(binding: ActivityMainBinding) {
        state = this@MainActivity.viewModel.state
    }

    override fun ActivityMainBinding.setUp() {
        viewModel = this@MainActivity.viewModel
        peopleAdapter = PeopleAdapter {
            this@MainActivity.viewModel.dispatch(MainAction.PersonClicked(it))
        }
        recyclerView.apply {
            adapter = peopleAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}