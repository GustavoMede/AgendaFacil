package com.example.agendafacil.repository.inputrepository

import com.example.agendafacil.dto.request.InputRequest

interface InputRepository {

    suspend fun onInputAdd(nome: String, descricao: String)

    suspend fun getAll(): List<InputRequest>

    suspend fun onClearInputList()
}