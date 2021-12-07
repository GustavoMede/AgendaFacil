package com.example.agendafacil.usecase.getinputsusecase

import com.example.agendafacil.dto.request.InputRequest
import com.example.agendafacil.repository.inputrepository.InputRepository

class OnGetInputsUseCaseImpl(private val repository: InputRepository): OnGetInputsUseCase {

    override suspend fun getInputs(): List<InputRequest> {
        return repository.getAll()
    }
}