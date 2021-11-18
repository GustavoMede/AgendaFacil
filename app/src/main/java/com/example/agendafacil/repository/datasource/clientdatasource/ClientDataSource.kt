package com.example.agendafacil.repository.datasource.clientdatasource

import com.example.agendafacil.dto.ClientDTO

interface ClientDataSource {

    suspend fun onCreateAccount(clientDTO: ClientDTO)
}