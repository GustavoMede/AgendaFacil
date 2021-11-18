package com.example.agendafacil.usecase.onprofessionalsignup

import com.example.agendafacil.dto.ProfessionalDTO

interface OnProfessionalSignUpUseCase {

    suspend fun onCreateAccount(professionalDTO: ProfessionalDTO)
}