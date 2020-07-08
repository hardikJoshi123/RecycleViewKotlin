package com.arc.test.endpoint

import com.arc.test.model.Data
import io.reactivex.Single
import javax.inject.Inject

class ImagesService {
    @Inject
    lateinit var api: ImagesApi
    init {
        DaggerApiComponent.create().inject(this)
    }
    fun getUsers(): Single<Data> {
        return api.getImages()
    }
}