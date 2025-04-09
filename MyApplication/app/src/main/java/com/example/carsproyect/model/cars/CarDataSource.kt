package com.example.carsproyect.model.cars

import android.content.Context
import com.example.carsproyect.model.services.ApiClient
import com.example.carsproyect.model.services.ApiServices
import java.io.IOException

class CarDataSource(private val context: Context) {
    private val apiService: ApiServices = ApiClient.create(context)

    suspend fun getAllCars(): List<Car>? {
        return try {
            val response = apiService.getCars()
            if (response.isSuccessful) {
                response.body()
            } else {
                throw Exception("Error: ${response.code()}")
            }
        } catch (e: Exception) {
            throw IOException("Error al obtener Cars", e)
        }
    }
    //manaejo de corutinas.

    suspend fun getGuardar(){

    }
}