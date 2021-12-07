package com.example.agendafacil.usecase.getinputsusecase

import com.example.agendafacil.dto.request.InputRequest

interface OnGetInputsUseCase {

    suspend fun getInputs(): List<InputRequest>
}