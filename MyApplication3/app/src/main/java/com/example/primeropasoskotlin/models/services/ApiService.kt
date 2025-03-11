package com.example.primeropasoskotlin.models.services

import com.example.primeropasoskotlin.models.Posts

import retrofit2.http.GET
import retrofit2.Call


interface ApiService {

    @GET("posts")
    fun getPosts():Call<List<Posts>>
    //mas empoints


}