package com.example.agendafacil.repository.datasource.professionaldatasource

import com.example.agendafacil.dto.request.ProfessionalRequest
import com.example.agendafacil.dto.response.ProfessionalResponse

class ProfessionalDataSourceImpl: ProfessionalDataSource {
    override suspend fun onCreateAccount(professionalRequest: ProfessionalRequest) {
        ProfessionalRepositoryRetrofit.getData().signUpRequest(professionalRequest)
    }
}