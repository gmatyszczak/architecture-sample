package pl.gmat.architecture.sample.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_person.*
import pl.gmat.architecture.sample.domain.Person

class PersonViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(person: Person) {
        nameTextView.text = person.name
    }
}
