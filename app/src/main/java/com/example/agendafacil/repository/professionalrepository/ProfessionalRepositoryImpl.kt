package com.example.agendafacil.repository.professionalrepository

import com.example.agendafacil.dto.request.ProfessionalRequest
import com.example.agendafacil.dto.response.ProfessionalResponse
import com.example.agendafacil.repository.datasource.professionaldatasource.ProfessionalDataSource

class ProfessionalRepositoryImpl(private val dataSource: ProfessionalDataSource): ProfessionalRepository {
    override suspend fun onCreateAccount(professionalRequest: ProfessionalRequest) {
        dataSource.onCreateAccount(professionalRequest)
    }
}