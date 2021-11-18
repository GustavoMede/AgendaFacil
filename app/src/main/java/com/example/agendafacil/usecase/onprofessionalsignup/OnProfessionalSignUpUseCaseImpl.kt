package com.example.agendafacil.usecase.onprofessionalsignup

import com.example.agendafacil.dto.ProfessionalDTO
import com.example.agendafacil.repository.professionalrepository.ProfessionalRepository

class OnProfessionalSignUpUseCaseImpl(private val repository: ProfessionalRepository): OnProfessionalSignUpUseCase {

    override suspend fun onCreateAccount(professionalDTO: ProfessionalDTO) {
        repository.onCreateAccount(professionalDTO)
    }
}