package com.example.agendafacil.repository.clientepository

import com.example.agendafacil.dto.request.ClientRequest

interface ClientRepository {

    suspend fun onCreateAccount(clientRequest: ClientRequest)
}