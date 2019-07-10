package pl.gmat.architecture.feature.details

import android.content.Context
import android.content.Intent
import android.view.MenuItem
import pl.gmat.architecture.core.di.Injector
import pl.gmat.architecture.core.domain.Person
import pl.gmat.architecture.core.feature.BaseActivity
import pl.gmat.architecture.core.feature.EffectHandler
import pl.gmat.architecture.feature.details.action.DetailsAction
import pl.gmat.architecture.feature.details.di.DaggerDetailsComponent
import pl.gmat.architecture.feature.details.effect.DetailsEffect
import pl.gmat.architecture.sample.R
import pl.gmat.architecture.sample.databinding.ActivityDetailsBinding
import javax.inject.Inject
import javax.inject.Provider

class DetailsActivity :
    BaseActivity<ActivityDetailsBinding, DetailsViewModel, DetailsState, DetailsEffect, DetailsAction>() {

    companion object {

        const val EXTRA_PERSON = "EXTRA_PERSON"

        fun createIntent(context: Context, person: Person) = Intent(context, DetailsActivity::class.java).apply {
            putExtra(EXTRA_PERSON, person)
        }
    }

    override val layoutId = R.layout.activity_details

    override val viewModelClass = DetailsViewModel::class.java

    @Inject
    override lateinit var effectHandlers: MutableMap<Class<*>, Provider<EffectHandler<DetailsEffect>>>

    override fun inject() = DaggerDetailsComponent.factory().create(this, Injector.coreComponent).inject(this)

    override fun ActivityDetailsBinding.setUp() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun ActivityDetailsBinding.observeState(binding: ActivityDetailsBinding) {
        state = viewModel.state
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        android.R.id.home -> {
            viewModel.dispatch(DetailsAction.Finish)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
