package com.example.agendafacil.repository.datasource.professionaldatasource

import com.example.agendafacil.dto.ProfessionalDTO

class ProfessionalDataSourceImpl: ProfessionalDataSource {
    override suspend fun onCreateAccount(professionalDTO: ProfessionalDTO) {
        ProfessionalRepositoryRetrofit.getData().signUpRequest(professionalDTO)
    }
}