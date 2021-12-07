package com.example.agendafacil.repository.datasource.inputadddatasource

import com.example.agendafacil.dto.request.InputRequest
import com.example.agendafacil.dto.response.InputResponse

interface InputAddLocalDataSource {

    suspend fun onInputAdd(input: InputRequest)

    suspend fun getAll(): List<InputRequest>

    suspend fun onClearInputList()
}