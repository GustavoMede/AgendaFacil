package com.example.agendafacil.repository.professionalrepository

import com.example.agendafacil.dto.ProfessionalDTO

interface ProfessionalRepository {

    suspend fun onCreateAccount(professionalDTO: ProfessionalDTO)
}