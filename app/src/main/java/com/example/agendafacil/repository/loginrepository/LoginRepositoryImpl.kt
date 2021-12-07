package com.example.agendafacil.repository.loginrepository

import com.example.agendafacil.dto.request.LoginRequest
import com.example.agendafacil.dto.response.LoginResponse
import com.example.agendafacil.repository.datasource.logindatasource.LoginDataSource

class LoginRepositoryImpl(private val dataSource: LoginDataSource): LoginRepository {

    override suspend fun onLogin(email: String, password: String): LoginResponse {
        return dataSource.onLogin(LoginRequest(email, password))
    }
}