package pl.gmat.architecture.sample.feature.main

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import pl.gmat.architecture.core.BaseActivity
import pl.gmat.architecture.core.EffectHandler
import pl.gmat.architecture.core.Injector
import pl.gmat.architecture.sample.R
import pl.gmat.architecture.sample.feature.main.action.MainAction
import pl.gmat.architecture.sample.feature.main.di.DaggerMainComponent
import pl.gmat.architecture.sample.feature.main.effect.MainEffect
import pl.gmat.architecture.sample.feature.main.widget.PeopleAdapter
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel, MainState, MainEffect, MainAction>() {

    override val layoutId = R.layout.activity_main

    override val viewModelClass = MainViewModel::class.java

    override fun inject() = DaggerMainComponent.factory().create(this, Injector.coreComponent).inject(this)

    @Inject
    lateinit var showPersonDetailsHandler: EffectHandler<MainEffect.ShowPersonDetails>

    private lateinit var peopleAdapter: PeopleAdapter

    override fun setUp() {
        peopleAdapter = PeopleAdapter {
            viewModel.dispatch(MainAction.PersonClicked(it))
        }
        recyclerView.apply {
            adapter = peopleAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    override fun render(state: MainState) {
        peopleAdapter.submitList(state.list)
    }

    override fun handleEffect(effect: MainEffect) = when (effect) {
        is MainEffect.ShowPersonDetails -> showPersonDetailsHandler.handle(effect)
    }
}