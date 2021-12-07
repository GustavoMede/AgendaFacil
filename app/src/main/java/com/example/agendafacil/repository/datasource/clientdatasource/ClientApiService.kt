package com.example.agendafacil.repository.datasource.clientdatasource

import com.example.agendafacil.dto.request.ClientRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ClientApiService {

    @POST("/clientes/cadastro")
    suspend fun signUpRequest(@Body clientRequest: ClientRequest)
}