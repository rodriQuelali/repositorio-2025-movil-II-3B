package com.example.primeropasoskotlin.models.services

import com.example.primeropasoskotlin.models.Posts

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {

    @GET("posts")
    fun getPosts():Call<List<Posts>>
    //mas empoints

    @POST("posts")
    fun getGuardar(@Body posts: Posts):Call<List<Posts>>

}