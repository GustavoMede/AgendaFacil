package com.example.agendafacil.repository.datasource.professionaldatasource

import com.example.agendafacil.dto.request.ProfessionalRequest
import com.example.agendafacil.dto.response.ProfessionalResponse

interface ProfessionalDataSource {

    suspend fun onCreateAccount(professionalRequest: ProfessionalRequest)
}