package com.example.agendafacil.repository.datasource.logindatasource

import com.example.agendafacil.dto.request.LoginRequest
import com.example.agendafacil.dto.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiService {

    @POST("/login")
    suspend fun loginRequest(@Body loginRequest: LoginRequest): LoginResponse
}