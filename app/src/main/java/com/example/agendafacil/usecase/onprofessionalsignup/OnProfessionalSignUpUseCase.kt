package com.example.agendafacil.usecase.onprofessionalsignup

import com.example.agendafacil.dto.request.ProfessionalRequest
import com.example.agendafacil.dto.response.ProfessionalResponse

interface OnProfessionalSignUpUseCase {

    suspend fun onCreateAccount(professionalRequest: ProfessionalRequest)
}