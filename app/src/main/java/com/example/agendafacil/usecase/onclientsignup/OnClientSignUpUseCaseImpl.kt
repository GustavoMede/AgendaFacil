package com.example.agendafacil.usecase.onclientsignup

import com.example.agendafacil.dto.request.ClientRequest
import com.example.agendafacil.repository.clientepository.ClientRepository

class OnClientSignUpUseCaseImpl(private val repository: ClientRepository): OnClientSignUpUseCase {

    override suspend fun onCreateAccount(clientRequest: ClientRequest) {
        repository.onCreateAccount(clientRequest)
    }
}