package com.example.agendafacil.repository.clientepository

import com.example.agendafacil.dto.request.ClientRequest
import com.example.agendafacil.repository.datasource.clientdatasource.ClientDataSource

class ClientRepositoryImpl(private val clientDataSourceImpl: ClientDataSource): ClientRepository {

    override suspend fun onCreateAccount(clientRequest: ClientRequest) {
        clientDataSourceImpl.onCreateAccount(clientRequest)
    }
}