package com.example.memoir.network

import com.example.memoir.models.DefaultResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import com.example.memoir.models.LoginResponse

interface MyApi {

    @FormUrlEncoded
    @POST("signup.php")
    fun createUser(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("username") username: String
    ): Call<DefaultResponse>

    @FormUrlEncoded
    @POST("login.php")
    fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

}