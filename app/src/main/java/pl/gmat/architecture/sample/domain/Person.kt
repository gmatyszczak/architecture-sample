package pl.gmat.architecture.sample.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(val name: String) : Parcelable