package com.example.primeropasoskotlin.models.services

import com.example.primeropasoskotlin.models.Posts
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    suspend fun getPosts():Response<List<Posts>>

    //mas empoints


}