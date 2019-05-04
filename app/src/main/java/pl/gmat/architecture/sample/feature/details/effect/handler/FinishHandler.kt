package pl.gmat.architecture.sample.feature.details.effect.handler

import androidx.appcompat.app.AppCompatActivity
import pl.gmat.architecture.core.EffectHandler
import pl.gmat.architecture.sample.feature.details.effect.DetailsEffect
import javax.inject.Inject

class FinishHandler @Inject constructor(
    private val activity: AppCompatActivity
) : EffectHandler<DetailsEffect.Finish> {

    override fun handle(effect: DetailsEffect.Finish) = activity.finish()
}