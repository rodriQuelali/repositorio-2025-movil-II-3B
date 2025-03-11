package com.example.primeropasoskotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.primeropasoskotlin.models.Post.PostsDao
import com.example.primeropasoskotlin.models.Post.PostsRepositori
import com.example.primeropasoskotlin.models.Posts
import retrofit2.Call
import retrofit2.Response

class PostViewModel (aplication:Application): AndroidViewModel(aplication){

    private val postDao:PostsDao

    val posts: LiveData<List<Posts>> get() = postDao.posts
    val error: LiveData<String> get() = postDao.error

    init {
     val postsRepositori = PostsRepositori(aplication)
     postDao = PostsDao(postsRepositori)
    }

    fun getPosts(){
        //viewModelScope.launch {
            postDao.getPosts()  // Asumiendo que getPosts() maneja todo internamente
        //}
    }

}