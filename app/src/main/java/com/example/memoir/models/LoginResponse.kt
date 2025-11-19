package com.example.memoir.models

data class LoginResponse(
    val error: Boolean,
    val message: String,
    val user: User?
)

data class User(
    val id: Int,
    val username: String,
    val email: String
)