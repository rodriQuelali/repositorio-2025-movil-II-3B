package com.example.carsproyect.data

import android.content.Context
import com.example.carsproyect.data.model.LoggedInUser
import com.example.carsproyect.data.model.LoginRequest
import com.example.carsproyect.model.services.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource(private val context: Context) {

    suspend fun login(username: String, password: String): Result<LoggedInUser> {
        try {

            val loginRequest = LoginRequest(email= username, password = password)
            val loginResponse = withContext(Dispatchers.IO){
                ApiClient.create(context).getLogin(loginRequest)
            }

            println("Respuesta exitosa: $loginResponse")

            saveSharpreferences(loginResponse.access)

            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), loginRequest.email)
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }

    //token and refresh
    fun saveSharpreferences(token: String){
        val sharedPreferences = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putString("ACCESS_TOKEN", token)
            apply()
        }
    }
}