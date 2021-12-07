package com.example.agendafacil.repository.datasource.logindatasource

import com.example.agendafacil.dto.request.LoginRequest
import com.example.agendafacil.dto.response.LoginResponse

interface LoginDataSource {

    suspend fun onLogin(loginRequest: LoginRequest): LoginResponse
}