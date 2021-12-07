package com.example.agendafacil.usecase.onlogin

import com.example.agendafacil.dto.response.LoginResponse
import com.example.agendafacil.repository.loginrepository.LoginRepository

class OnLoginUseCaseImpl(private val repository: LoginRepository): OnLoginUseCase {

    override suspend fun onLogin(email: String, password: String): LoginResponse {
        return repository.onLogin(email, password)
    }
}