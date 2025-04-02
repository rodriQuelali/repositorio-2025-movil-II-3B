package com.example.primeropasoskotlin.models.Post

import android.app.Application
import android.content.Context
import android.widget.TabHost
import com.example.primeropasoskotlin.models.Posts
import com.example.primeropasoskotlin.models.services.ApiClient
import com.example.primeropasoskotlin.models.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsRepositori(context: Context) {

    private val apiService:ApiService = ApiClient.instance

    fun getPosts(callback: (List<Posts>?)->Unit, errorCallback: (Throwable)->Unit) {
        apiService.getPosts().enqueue(object : Callback<List<Posts>>{
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if (response.isSuccessful){
                    callback(response.body())
                }else{
                    errorCallback(Exception("error: ${response.code()}"))
                }
            }
            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                errorCallback(t)
            }

        })
    }

    fun getGuardar(posts: Posts,callback: (Posts) -> Unit, errorCallback: (Throwable) -> Unit){

        apiService.getGuardar(posts).enqueue(object : Callback<Posts>{
            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                if (response.isSuccessful){
                    callback(response.body()!!)
                    println(response.body())
                }else{
                    errorCallback(Exception("error: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<Posts>, t: Throwable) {
                errorCallback(t)
            }

        })
    }

    fun editPost(id:Int ,posts: Posts,callback: (Posts) -> Unit, errorCallback: (Throwable) -> Unit){
        apiService.patchPost(id,posts).enqueue(object : Callback<Posts>{
            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {

            }

            override fun onFailure(call: Call<Posts>, t: Throwable) {

            }

        })
    }

}