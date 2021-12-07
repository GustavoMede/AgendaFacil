package com.example.agendafacil.repository.datasource.clientdatasource

import com.example.agendafacil.dto.request.ClientRequest

interface ClientDataSource {

    suspend fun onCreateAccount(clientRequest: ClientRequest)
}