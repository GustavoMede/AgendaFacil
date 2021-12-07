package com.example.agendafacil.repository.servicerepository

import com.example.agendafacil.dto.request.ServiceRequest
import com.example.agendafacil.dto.response.ServiceResponse
import com.example.agendafacil.repository.datasource.servicedatasource.ServiceDataSource

class ServiceRepositoryImpl(private val dataSource: ServiceDataSource): ServiceRepository {

    override suspend fun getServices(): List<ServiceResponse> {
        return dataSource.getServices()
    }

    override suspend fun onServiceAdd(serviceRequest: ServiceRequest) {
        dataSource.onServiceAdd(serviceRequest)
    }
}