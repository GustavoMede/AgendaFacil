package com.example.agendafacil.repository.inputrepository

import com.example.agendafacil.dto.request.InputRequest
import com.example.agendafacil.repository.datasource.inputadddatasource.InputAddLocalDataSource

class InputRepositoryImpl(private val datasource: InputAddLocalDataSource): InputRepository {

    override suspend fun onInputAdd(nome: String, descricao: String) {
        datasource.onInputAdd(InputRequest(nome, descricao))
    }

    override suspend fun getAll(): List<InputRequest> {
        return datasource.getAll()
    }

    override suspend fun onClearInputList() {
        datasource.onClearInputList()
    }
}