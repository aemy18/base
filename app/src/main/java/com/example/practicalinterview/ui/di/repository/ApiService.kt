package com.example.practicalinterview.ui.di.repository

import com.example.practicalinterview.ui.URLFactory
import com.example.practicalinterview.ui.model.User
import com.example.practicalinterview.ui.model.requests.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST(URLFactory.API_LOGIN)
    suspend fun login(@Body request: LoginRequest): Response<User>
}