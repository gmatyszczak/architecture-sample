package pl.gmat.architecture.core.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject

abstract class BaseActivity<Binding : ViewDataBinding, ViewModel : BaseViewModel<State, Effect, Action>, State, Effect, Action>
    : AppCompatActivity() {

    protected lateinit var viewModel: ViewModel

    protected abstract val layoutId: Int

    protected abstract val viewModelClass: Class<ViewModel>

    protected abstract fun inject()

    protected abstract fun handleEffect(effect: Effect)

    protected abstract fun Binding.observeState(binding: Binding)

    protected abstract fun Binding.setUp()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[viewModelClass]
        DataBindingUtil.setContentView<Binding>(this, layoutId).apply {
            observeState(this)
            setUp()
            lifecycleOwner = this@BaseActivity
        }
        viewModel.effect.observe(this::handleEffect)
    }

    private fun <Type> LiveData<Type>.observe(function: (Type) -> Unit) =
        this.observe(this@BaseActivity, Observer {
            function(it)
        })
}