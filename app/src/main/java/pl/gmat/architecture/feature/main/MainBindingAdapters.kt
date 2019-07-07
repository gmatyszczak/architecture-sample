package pl.gmat.architecture.feature.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import pl.gmat.architecture.core.domain.Person
import pl.gmat.architecture.feature.main.widget.PeopleAdapter

@BindingAdapter("people")
fun setPeople(recyclerView: RecyclerView, people: List<Person>?) {
    (recyclerView.adapter as? PeopleAdapter)?.submitList(people)
}