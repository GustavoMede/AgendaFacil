package com.example.agendafacil.repository.datasource.inputadddatasource

import com.example.agendafacil.dto.request.InputRequest

class InputAddLocalDataSourceImpl: InputAddLocalDataSource {

    override suspend fun onInputAdd(input: InputRequest) {
        inputs.add(input)
    }

    override suspend fun getAll(): List<InputRequest> {
        return inputs.toList()
    }

    override suspend fun onClearInputList() {
        inputs.clear()
    }

    companion object {
        private val inputs = mutableListOf<InputRequest>()
    }
}