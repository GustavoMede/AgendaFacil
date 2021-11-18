package com.example.agendafacil.repository.clientrepository

import com.example.agendafacil.dto.ClientDTO

interface ClientRepository {

    suspend fun onCreateAccount(clientDTO: ClientDTO)
}