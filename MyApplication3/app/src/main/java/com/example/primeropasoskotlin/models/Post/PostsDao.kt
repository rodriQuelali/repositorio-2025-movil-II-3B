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

    private val _results = MutableLiveData<Boolean>()
    val results :LiveData<Boolean> get() = _results

     fun getPosts() = potsRepositori.getPosts(
         callback = { postList ->
              _posts.value = postList
         },
         errorCallback = { throwable ->
              _error.value = throwable.message
         }
     )

    fun getGuardar(posts: Posts){

        potsRepositori.getGuardar(
            posts = posts,
            callback = {_results.value = true},
            errorCallback = {_results.value = false}
        )
    }

}