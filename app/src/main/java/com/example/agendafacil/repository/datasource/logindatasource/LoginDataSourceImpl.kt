package com.example.agendafacil.repository.datasource.logindatasource

import com.example.agendafacil.dto.request.LoginRequest
import com.example.agendafacil.dto.response.LoginResponse

class LoginDataSourceImpl: LoginDataSource {

    override suspend fun onLogin(loginRequest: LoginRequest): LoginResponse {
       return LoginRepositoryRetrofit.submitLogin().loginRequest(loginRequest)
    }
}