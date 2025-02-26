package com.example.primeropasoskotlin.models.Post

import com.example.primeropasoskotlin.models.Posts
import com.example.primeropasoskotlin.models.services.ApiClient
import retrofit2.Response
import retrofit2.Retrofit

class PostsRepositori {


    fun getPosts(): Response<MutableList<Posts>> {
        val response = ApiClient.instance.getPosts()
        return  response
    }
}