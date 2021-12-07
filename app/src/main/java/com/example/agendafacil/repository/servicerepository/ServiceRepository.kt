package com.example.agendafacil.repository.servicerepository

import com.example.agendafacil.dto.request.ServiceRequest
import com.example.agendafacil.dto.response.ServiceResponse

interface ServiceRepository {

    suspend fun getServices(): List<ServiceResponse>

    suspend fun onServiceAdd(serviceRequest: ServiceRequest)
}