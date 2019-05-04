package pl.gmat.architecture.sample.data

import io.reactivex.Single
import retrofit2.http.GET

interface PeopleService {

    @GET("people")
    fun getPeople(): Single<PeopleResponse>
}
