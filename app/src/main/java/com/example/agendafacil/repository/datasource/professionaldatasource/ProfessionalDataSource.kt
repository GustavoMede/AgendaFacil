package com.example.agendafacil.repository.datasource.professionaldatasource

import com.example.agendafacil.dto.ProfessionalDTO

interface ProfessionalDataSource {

    suspend fun onCreateAccount(professionalDTO: ProfessionalDTO)
}