package com.example.agendafacil.usecase.onclientsignup

import com.example.agendafacil.dto.ClientDTO
import com.example.agendafacil.repository.clientrepository.ClientRepository

class OnClientSignUpUseCaseImpl(private val repository: ClientRepository): OnClientSignUpUseCase {

    override suspend fun onCreateAccount(clientDTO: ClientDTO) {
        repository.onCreateAccount(clientDTO)
    }
}