package com.arc.test.endpoint

import com.arc.test.model.Data
import io.reactivex.Single
import retrofit2.http.GET

interface   ImagesApi {
    @GET("latest")
    fun getImages(): Single<Data>
}