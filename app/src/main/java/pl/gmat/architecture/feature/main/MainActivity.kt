package pl.gmat.architecture.feature.main

import androidx.recyclerview.widget.LinearLayoutManager
import pl.gmat.architecture.core.BaseActivity
import pl.gmat.architecture.core.EffectHandler
import pl.gmat.architecture.core.Injector
import pl.gmat.architecture.feature.main.action.MainAction
import pl.gmat.architecture.feature.main.di.DaggerMainComponent
import pl.gmat.architecture.feature.main.effect.MainEffect
import pl.gmat.architecture.feature.main.widget.PeopleAdapter
import pl.gmat.architecture.sample.R
import pl.gmat.architecture.sample.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel, MainState, MainEffect, MainAction>() {

    override val layoutId = R.layout.activity_main

    override val viewModelClass = MainViewModel::class.java

    @Inject
    lateinit var showPersonDetailsHandler: EffectHandler<MainEffect.ShowPersonDetails>

    private lateinit var peopleAdapter: PeopleAdapter

    override fun inject() = DaggerMainComponent.factory().create(this, Injector.coreComponent).inject(this)

    override fun ActivityMainBinding.observeState(binding: ActivityMainBinding) {
        state = viewModel.state
    }

    override fun ActivityMainBinding.setUp() {
        peopleAdapter = PeopleAdapter {
            viewModel.dispatch(MainAction.PersonClicked(it))
        }
        recyclerView.apply {
            adapter = peopleAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    override fun handleEffect(effect: MainEffect) = when (effect) {
        is MainEffect.ShowPersonDetails -> showPersonDetailsHandler.handle(effect)
    }
}