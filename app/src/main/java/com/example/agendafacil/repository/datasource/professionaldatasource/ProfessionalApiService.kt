package com.example.agendafacil.repository.datasource.professionaldatasource

import com.example.agendafacil.dto.request.ProfessionalRequest
import com.example.agendafacil.dto.response.ProfessionalResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProfessionalApiService {

    @POST("/profissionais/cadastro")
    suspend fun signUpRequest(@Body professionalRequest: ProfessionalRequest): Response<ResponseBody>

}