package com.example.primeropasoskotlin

import android.content.Intent
import android.os.Bundle
import android.view.PixelCopy.Request
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import com.example.primeropasoskotlin.ui.Home

class Login : AppCompatActivity() {

    lateinit var btnLogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //cargarHttpPosts()
        cargarR()
        estadoButon()
        //cargarVolley()
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