package com.example.agendafacil.usecase.onclientsignup

import com.example.agendafacil.dto.ClientDTO

interface OnClientSignUpUseCase {

    suspend fun onCreateAccount(clientDTO: ClientDTO)
}