package pl.gmat.architecture.core.di

import dagger.Component
import pl.gmat.architecture.core.data.ApiModule
import pl.gmat.architecture.core.data.PeopleService
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class
    ]
)
interface CoreComponent {

    fun peopleService(): PeopleService
}