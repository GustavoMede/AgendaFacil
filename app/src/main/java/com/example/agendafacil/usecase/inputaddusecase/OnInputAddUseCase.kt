package com.example.agendafacil.usecase.inputaddusecase

interface OnInputAddUseCase {

    suspend fun onInputAdd(nome: String, descricao: String)
}