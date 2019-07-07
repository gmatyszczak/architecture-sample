package pl.gmat.architecture.core.data

import io.reactivex.Single
import retrofit2.http.GET

interface PeopleService {

    @GET("people")
    fun getPeople(): Single<PeopleResponse>
}
