package com.example.agendafacil.repository.datasource.servicedatasource

import com.example.agendafacil.dto.request.ServiceRequest
import com.example.agendafacil.dto.response.ServiceResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceApiService {

    @GET("/profissionais/servicos")
    suspend fun getServices(): List<ServiceResponse>

    @POST("/profissionais/servico")
    suspend fun serviceAdd(@Body serviceRequest: ServiceRequest)
}