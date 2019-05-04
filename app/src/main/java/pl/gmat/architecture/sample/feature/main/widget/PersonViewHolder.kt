package pl.gmat.architecture.sample.feature.main.widget

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_person.*
import pl.gmat.architecture.sample.domain.Person

class PersonViewHolder(
    override val containerView: View,
    private val onClick: (Person) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(person: Person) {
        nameTextView.text = person.name
        containerView.setOnClickListener { onClick(person) }
    }
}
