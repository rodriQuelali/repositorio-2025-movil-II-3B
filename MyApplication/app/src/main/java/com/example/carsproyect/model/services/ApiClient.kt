package com.example.carsproyect.model.services

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "http://3.86.202.19:8000/"

    // Instancia única de ApiService
    private var apiService: ApiServices? = null

    fun create(context: Context): ApiServices {

        // Verifica si la instancia ya existe
        if (apiService == null) {

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(AuthInterceptor(context)) // Agregar el interceptor
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient) // Usa el cliente con el interceptor
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            apiService = retrofit.create(ApiServices::class.java) // Crea la instancia
        }
        return apiService!! // Devuelve la instancia existente
    }
}