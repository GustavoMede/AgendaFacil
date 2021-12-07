package com.example.agendafacil.usecase.onprofessionalsignup

import com.example.agendafacil.dto.request.ProfessionalRequest
import com.example.agendafacil.dto.response.ProfessionalResponse
import com.example.agendafacil.repository.professionalrepository.ProfessionalRepository
import java.lang.Exception

class OnProfessionalSignUpUseCaseImpl(private val repository: ProfessionalRepository): OnProfessionalSignUpUseCase {

    override suspend fun onCreateAccount(professionalRequest: ProfessionalRequest) {
        repository.onCreateAccount(professionalRequest)
    }
}