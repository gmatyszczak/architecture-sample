package pl.gmat.architecture.sample.feature.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import pl.gmat.architecture.sample.R
import pl.gmat.architecture.sample.domain.Person

private val diffUtil = object : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Person, newItem: Person) = oldItem == newItem
}

class PeopleAdapter(private val onClick: (Person) -> Unit) : ListAdapter<Person, PersonViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PersonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false), onClick)

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) = holder.bind(getItem(position))

}