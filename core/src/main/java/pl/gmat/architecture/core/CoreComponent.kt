package pl.gmat.architecture.core

import dagger.Component
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