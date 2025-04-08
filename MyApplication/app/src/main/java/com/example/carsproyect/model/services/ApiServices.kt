package com.example.carsproyect.model.services

import android.telecom.Call
import com.example.carsproyect.data.model.LoginRequest
import com.example.carsproyect.data.model.LoginResponse
import com.example.carsproyect.model.cars.Car
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiServices {


    @GET("cars/")
    suspend fun getCars(): Response<List<Car>>

    @POST("auth/api/token/")
    @Headers("Content-Type:application/json")
    suspend fun getLogin(@Body loginRequest: LoginRequest): LoginResponse

}