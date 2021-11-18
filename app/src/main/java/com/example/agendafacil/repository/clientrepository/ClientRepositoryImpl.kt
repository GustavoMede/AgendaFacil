package com.example.agendafacil.repository.clientrepository

import com.example.agendafacil.dto.ClientDTO
import com.example.agendafacil.repository.datasource.clientdatasource.ClientDataSource

class ClientRepositoryImpl(private val clientDataSourceImpl: ClientDataSource): ClientRepository {

    override suspend fun onCreateAccount(clientDTO: ClientDTO) {
        clientDataSourceImpl.onCreateAccount(clientDTO)
    }
}