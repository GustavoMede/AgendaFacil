package com.example.agendafacil.usecase.onclearinputlistusecase

import com.example.agendafacil.repository.inputrepository.InputRepository

class OnClearInputListUseCaseImpl(private val repository: InputRepository): OnClearInputListUseCase {

    override suspend fun onClearInputList() {
        repository.onClearInputList()
    }
}