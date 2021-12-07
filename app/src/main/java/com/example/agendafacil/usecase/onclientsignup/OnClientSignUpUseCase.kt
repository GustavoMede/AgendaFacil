package com.example.agendafacil.usecase.onclientsignup

import com.example.agendafacil.dto.request.ClientRequest

interface OnClientSignUpUseCase {

    suspend fun onCreateAccount(clientRequest: ClientRequest)
}