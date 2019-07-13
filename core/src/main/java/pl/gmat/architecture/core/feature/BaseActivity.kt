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
import javax.inject.Provider

abstract class BaseActivity<Binding : ViewDataBinding, ViewModel : BaseViewModel<State, Effect, Action>, State, Effect : Any, Action : Any>
    : AppCompatActivity() {

    protected lateinit var viewModel: ViewModel

    protected abstract val layoutId: Int

    protected abstract val viewModelClass: Class<ViewModel>

    protected abstract fun inject()

    protected abstract fun Binding.observeState(binding: Binding)

    protected abstract fun Binding.setUp()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var effectHandlers: MutableMap<Class<*>, Provider<EffectHandler<Effect>>>

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

    private fun handleEffect(effect: Effect) {
        effectHandlers[effect::class.java]?.get()?.handle(effect) ?: throw IllegalStateException("No handler for $effect")
    }
}