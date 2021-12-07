package com.example.agendafacil.repository.datasource.servicedatasource

import com.example.agendafacil.dto.request.ServiceRequest
import com.example.agendafacil.dto.response.ServiceResponse

interface ServiceDataSource {

    suspend fun getServices(): List<ServiceResponse>

    suspend fun onServiceAdd(serviceRequest: ServiceRequest)
}