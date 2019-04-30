package pl.gmat.architecture.sample

import dagger.Module
import dagger.Provides
import pl.gmat.architecture.core.ApplicationScope
import pl.gmat.architecture.sample.data.PeopleService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    @ApplicationScope
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://swapi.co/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    @Provides
    fun providePeopleService(retrofit: Retrofit): PeopleService = retrofit.create(PeopleService::class.java)
}
