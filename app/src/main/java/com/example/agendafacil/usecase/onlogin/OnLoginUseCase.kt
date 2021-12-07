package com.example.agendafacil.usecase.onlogin

import com.example.agendafacil.dto.response.LoginResponse

interface OnLoginUseCase {

    suspend fun onLogin(email: String, password: String): LoginResponse
}