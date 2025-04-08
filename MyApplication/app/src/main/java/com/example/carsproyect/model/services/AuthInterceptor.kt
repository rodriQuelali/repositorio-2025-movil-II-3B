package com.example.carsproyect.model.services

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val context: Context): Interceptor{

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val token = getAccessToken()

        // Verifica si la solicitud es para el endpoint de login
        if (!request.url.encodedPath.contains("/auth/api/token") && !token.isNullOrEmpty()) {
            // Solo añadir el token si no es una solicitud de login y el token no es nulo
            val newRequest = request.newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
            return chain.proceed(newRequest)
        }

        // Procede con la solicitud original si es un login o no hay token
        return chain.proceed(request)
    }

    private fun getAccessToken(): String? {
        val sharedPreferences = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
        return sharedPreferences.getString("ACCESS_TOKEN", null)
    }
}