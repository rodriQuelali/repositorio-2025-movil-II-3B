package com.example.primeropasoskotlin.models.Post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.primeropasoskotlin.models.Posts
import retrofit2.Call
import retrofit2.Response

class PostsDao (private val potsRepositori:PostsRepositori){

     private val _posts = MutableLiveData<List<Posts>>()
     val posts: LiveData<List<Posts>> get() = _posts

     private val _error = MutableLiveData<String>()
     val error: LiveData<String> get() = _error

     fun getPosts() = potsRepositori.getPosts(
         callback = { postList ->
              _posts.value = postList
         },
         errorCallback = { throwable ->
              _error.value = throwable.message
         }
     )

}