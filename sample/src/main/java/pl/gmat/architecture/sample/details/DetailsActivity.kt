package pl.gmat.architecture.sample.details

import pl.gmat.architecture.core.BaseActivity
import pl.gmat.architecture.sample.R
import pl.gmat.architecture.sample.SampleAppInjector

class DetailsActivity : BaseActivity<DetailsViewModel, DetailsState, DetailsEffect, DetailsAction>() {

    override val layoutId = R.layout.activity_details

    override val viewModelClass = DetailsViewModel::class.java

    override fun inject() = SampleAppInjector.appComponent.detailsComponentFactory().create(this).inject(this)

    override fun setUp() = Unit

    override fun render(state: DetailsState) = Unit
}
