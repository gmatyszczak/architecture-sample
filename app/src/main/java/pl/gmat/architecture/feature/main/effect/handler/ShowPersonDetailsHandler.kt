package pl.gmat.architecture.feature.main.effect.handler

import androidx.appcompat.app.AppCompatActivity
import pl.gmat.architecture.core.EffectHandler
import pl.gmat.architecture.feature.details.DetailsActivity
import pl.gmat.architecture.feature.main.effect.MainEffect
import javax.inject.Inject

class ShowPersonDetailsHandler @Inject constructor(
    private val activity: AppCompatActivity
) : EffectHandler<MainEffect.ShowPersonDetails> {

    override fun handle(effect: MainEffect.ShowPersonDetails) {
        activity.startActivity(DetailsActivity.createIntent(activity, effect.person))
    }
}