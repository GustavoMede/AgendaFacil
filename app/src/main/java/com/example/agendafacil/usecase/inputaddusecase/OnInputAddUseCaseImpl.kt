package com.example.agendafacil.usecase.inputaddusecase

import com.example.agendafacil.repository.inputrepository.InputRepository

class OnInputAddUseCaseImpl(private val repository: InputRepository): OnInputAddUseCase {

    override suspend fun onInputAdd(nome: String, descricao: String) {
        repository.onInputAdd(nome, descricao)
    }
}