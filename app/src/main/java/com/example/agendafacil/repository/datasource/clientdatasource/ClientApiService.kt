package com.example.agendafacil.repository.datasource.clientdatasource

import com.example.agendafacil.dto.ClientDTO
import retrofit2.http.Body
import retrofit2.http.POST

interface ClientApiService {

    @POST("/clientes/cadastro")
    suspend fun signUpRequest(@Body clientDTO: ClientDTO)
}