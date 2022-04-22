package dev.ogabek.mvvmpractice.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    var BASE_URL = "https://6260f1b3f429c20deb981149.mockapi.io/"

    fun getRetrofit(): Retrofit {
        val build = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return build
    }

    fun <T> createService(service: Class<T>): T {
        return getRetrofit().create(service)
    }

}