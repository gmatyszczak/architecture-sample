package pl.gmat.architecture.sample.main

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import pl.gmat.architecture.core.BaseActivity
import pl.gmat.architecture.sample.R
import pl.gmat.architecture.sample.SampleAppInjector

class MainActivity : BaseActivity<MainViewModel, MainState, MainEffect>() {

    override val layoutId = R.layout.activity_main

    override val viewModelClass = MainViewModel::class.java

    override fun inject() = SampleAppInjector.appComponent.mainComponentFactory().create(this).inject(this)

    private lateinit var peopleAdapter: PeopleAdapter

    override fun setUp() {
        peopleAdapter = PeopleAdapter()
        recyclerView.apply {
            adapter = peopleAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    override fun render(state: MainState) {
        peopleAdapter.submitList(state.list)
    }
}