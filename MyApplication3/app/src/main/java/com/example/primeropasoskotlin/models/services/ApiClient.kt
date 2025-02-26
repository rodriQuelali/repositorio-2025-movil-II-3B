package com.example.primeropasoskotlin.models.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private val URL_BASE = "https://jsonplaceholder.typicode.com/"


    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }


}