package com.example.agendafacil.repository.loginrepository

import com.example.agendafacil.dto.response.LoginResponse

interface LoginRepository {

    suspend fun onLogin(email: String, password: String): LoginResponse
}