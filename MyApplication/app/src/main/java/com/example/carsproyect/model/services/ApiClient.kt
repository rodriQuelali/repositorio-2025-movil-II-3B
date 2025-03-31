package com.example.carsproyect.model.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val URL_BASE = "https://jsonplaceholder.typicode.com/"


    val instance: ApiServices by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiServices::class.java)
    }
}