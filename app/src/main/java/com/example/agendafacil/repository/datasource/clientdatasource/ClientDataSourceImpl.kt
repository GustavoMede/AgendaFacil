package com.example.agendafacil.repository.datasource.clientdatasource

import com.example.agendafacil.dto.ClientDTO

class ClientDataSourceImpl: ClientDataSource {

    override suspend fun onCreateAccount(clientDTO: ClientDTO) {
        ClientRepositoryRetrofit.getData().signUpRequest(clientDTO)
    }
}