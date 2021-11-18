package com.example.agendafacil.repository.datasource.professionaldatasource

import com.example.agendafacil.dto.ProfessionalDTO
import retrofit2.http.Body
import retrofit2.http.POST

interface ProfessionalApiService {

    @POST("/profissionais/cadastro")
    suspend fun signUpRequest(@Body professionalDTO: ProfessionalDTO)
}