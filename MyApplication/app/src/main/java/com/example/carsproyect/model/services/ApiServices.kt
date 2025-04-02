package com.example.carsproyect.model.services

import android.telecom.Call
import com.example.carsproyect.data.model.LoginRequest
import com.example.carsproyect.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiServices {

    @POST("auth/api/token/")
    @Headers("Content-Type:application/json")
    suspend fun getLogin(@Body loginRequest: LoginRequest): LoginResponse

}