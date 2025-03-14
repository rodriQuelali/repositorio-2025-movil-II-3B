package com.example.primeropasoskotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.PixelCopy.Request
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.primeropasoskotlin.models.Posts
import com.example.primeropasoskotlin.models.services.ApiClient

import com.example.primeropasoskotlin.ui.Home
import com.example.primeropasoskotlin.viewmodel.PostViewModel
import retrofit2.Retrofit

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Objects

class Login : AppCompatActivity() {

    lateinit var btnLogin:Button

    private val postViewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configura las observaciones
        //setupObservers()

        // Carga los posts
        //loadPosts()

        //httpRretofig()

        cargarR()
        estadoButon()

        setObserveSave()

        val guardarPost = Posts(102,1, "alan", "brito brito")

        postViewModel.getGuardar(guardarPost)

    }
    //crear la funcion de cargar R
    fun cargarR(){
        btnLogin = findViewById(R.id.btnRegistrarProveedor)
    }

    //estado button
    fun estadoButon(){
        btnLogin.setOnClickListener{
            var aa = Intent(this, Home::class.java)
            startActivity(aa)
        }
    }

    //confeccionar con lisView o recicleyView para el listado de datos.

    //el Edit, guardar, list, delete, grud del empoints jsonplaceholder.

    private fun setObserveSave(){
        postViewModel.result.observe(this){ isSucess ->
            if(isSucess){
                Log.d("POST", "Registro Exitoso............--------")
            }else{
                Log.e("POST", "Error al registrar------------------")
            }
        }
    }

    private fun setupObservers() {
        // Observa los posts
        postViewModel.posts.observe(this) { posts ->
            posts?.forEach {
                Log.e("Post", "Title: ${it.title}, Body: ${it.body}")
            }
        }

        // Observa los errores
        postViewModel.error.observe(this) { errorMessage ->
            errorMessage?.let {
                Log.e("Error", it)
                // Aquí puedes mostrar un mensaje de error en la UI
            }
        }
    }

    private fun loadPosts() {
        postViewModel.getPosts() // Carga los posts
    }

    /*fun httpRretofig(){
        ApiClient.instance.getPosts().enqueue(object: Callback<List<Posts>>{

        })
        ApiClient.instance.getPosts().enqueue(object : Callback<List<Posts>> {
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if (response.isSuccessful) {
                    val posts = response.body()
                    posts?.forEach {
                        Log.e("Post", "Title: ${it.title}, Body: ${it.body}")
                    }
                }
            }
            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {

                Log.e("Error", t.message.toString())
            }
        })

    }*/

    /*fun cargarHttpPosts(){
        val queue = Volley.newRequestQueue(this)
        val url: String = "https://jsonplaceholder.typicode.com/posts"

        val strintRequest = StringRequest(com.android.volley.Request.Method.GET, url,
            Response.Listener<String>{ response ->
               println("Los datos ${response}")
            },
            Response.ErrorListener { println("Erro en la peticion") })

        queue.add(strintRequest)

    }*/
}