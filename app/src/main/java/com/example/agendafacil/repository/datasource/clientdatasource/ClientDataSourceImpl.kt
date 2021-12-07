package com.example.agendafacil.repository.datasource.clientdatasource

import com.example.agendafacil.dto.request.ClientRequest

class ClientDataSourceImpl: ClientDataSource {

    override suspend fun onCreateAccount(clientRequest: ClientRequest) {
        ClientRepositoryRetrofit.getData().signUpRequest(clientRequest)
    }
}