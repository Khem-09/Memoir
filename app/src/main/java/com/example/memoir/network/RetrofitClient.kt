package com.example.memoir.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2/memoir_api/"

    val instance: MyApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL) // This connects to your Laptop's XAMPP
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }
}