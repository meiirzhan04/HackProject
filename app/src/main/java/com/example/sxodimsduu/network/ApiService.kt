package com.example.sxodimsduu.network

import com.example.sxodimsduu.login.LoginRequest
import com.example.sxodimsduu.login.LoginResponse
import com.example.sxodimsduu.login.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    // Эндпоинт для регистрации нового пользователя
    @POST("api/users/")
    fun signUp(@Body user: User): Call<User>

    @POST("api/api-token-auth/")
    fun login(@Body credentials: LoginRequest): Call<LoginResponse>
}