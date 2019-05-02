package pl.gmat.architecture.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject

abstract class BaseActivity<ViewModel : BaseViewModel<State, E, Action>, State, E : Effect, Action>
    : AppCompatActivity() {

    protected lateinit var viewModel: ViewModel

    protected abstract val layoutId: Int

    protected abstract val viewModelClass: Class<ViewModel>

    protected abstract fun inject()

    abstract fun render(state: State)

    abstract fun handleEffect(effect: E)

    abstract fun setUp()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        setUp()
        viewModel = ViewModelProviders.of(this, viewModelFactory)[viewModelClass]
        viewModel.effect.observe { it.handleIfNotHandled { handleEffect(it) } }
        viewModel.state.observe { render(it) }
    }

    private fun <Type> LiveData<Type>.observe(function: (Type) -> Unit) =
        this.observe(this@BaseActivity, Observer {
            function(it)
        })
}