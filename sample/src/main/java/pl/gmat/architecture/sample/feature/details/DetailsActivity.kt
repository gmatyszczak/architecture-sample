package pl.gmat.architecture.sample.feature.details

import android.content.Context
import android.content.Intent
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_details.*
import pl.gmat.architecture.core.BaseActivity
import pl.gmat.architecture.core.EffectHandler
import pl.gmat.architecture.sample.R
import pl.gmat.architecture.sample.SampleAppInjector
import pl.gmat.architecture.sample.domain.Person
import pl.gmat.architecture.sample.feature.details.action.DetailsAction
import pl.gmat.architecture.sample.feature.details.effect.DetailsEffect
import javax.inject.Inject

class DetailsActivity : BaseActivity<DetailsViewModel, DetailsState, DetailsEffect, DetailsAction>() {

    companion object {

        const val EXTRA_PERSON = "EXTRA_PERSON"

        fun createIntent(context: Context, person: Person) = Intent(context, DetailsActivity::class.java).apply {
            putExtra(EXTRA_PERSON, person)
        }
    }

    override val layoutId = R.layout.activity_details

    override val viewModelClass = DetailsViewModel::class.java

    @Inject
    lateinit var finishHandler: EffectHandler<DetailsEffect.Finish>

    override fun inject() = SampleAppInjector.appComponent.detailsComponentFactory().create(this).inject(this)

    override fun setUp() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun render(state: DetailsState) {
        nameTextView.text = state.person.name
    }

    override fun handleEffect(effect: DetailsEffect) = when(effect) {
        is DetailsEffect.Finish -> finishHandler.handle(effect)
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        android.R.id.home -> {
            viewModel.dispatch(DetailsAction.Finish)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
