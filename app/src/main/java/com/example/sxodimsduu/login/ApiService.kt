package com.example.sxodimsduu.login

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    // Эндпоинт для регистрации нового пользователя
    @POST("api/users/")
    fun signUp(@Body user: User): Call<User>
}
