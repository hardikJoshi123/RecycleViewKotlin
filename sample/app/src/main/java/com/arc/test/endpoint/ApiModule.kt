package com.arc.test.endpoint

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {
    private val BASE_URL = "http://www.splashbase.co/api/v1/images/"
    @Provides
    fun provideUsersApi(): ImagesApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ImagesApi::class.java)
    }
    @Provides
    fun provideUsersService(): ImagesService {
        return ImagesService()
    }
}