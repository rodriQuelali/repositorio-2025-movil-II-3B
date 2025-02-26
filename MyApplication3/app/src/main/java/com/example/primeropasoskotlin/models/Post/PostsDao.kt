package com.example.primeropasoskotlin.models.Post

import com.example.primeropasoskotlin.models.Posts
import retrofit2.Response

class PostsDao (private val potsRepositori:PostsRepositori){

    fun getPosts(): Response<MutableList<Posts>> = potsRepositori.getPosts()

    
}