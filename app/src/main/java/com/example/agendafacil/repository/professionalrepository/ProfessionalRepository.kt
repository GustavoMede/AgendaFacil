package com.example.agendafacil.repository.professionalrepository

import com.example.agendafacil.dto.request.ProfessionalRequest
import com.example.agendafacil.dto.response.ProfessionalResponse

interface ProfessionalRepository {

    suspend fun onCreateAccount(professionalRequest: ProfessionalRequest)
}