package com.example.agendafacil.repository.professionalrepository

import com.example.agendafacil.dto.ProfessionalDTO
import com.example.agendafacil.repository.datasource.professionaldatasource.ProfessionalDataSource

class ProfessionalRepositoryImpl(private val dataSource: ProfessionalDataSource): ProfessionalRepository {
    override suspend fun onCreateAccount(professionalDTO: ProfessionalDTO) {
        dataSource.onCreateAccount(professionalDTO)
    }
}