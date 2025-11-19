package com.example.memoir.network

import com.example.memoir.models.DefaultResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("signup.php")
    fun createUser(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("username") username: String
    ): Call<DefaultResponse>

}