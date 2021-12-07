package com.example.agendafacil.repository.datasource.servicedatasource

import com.example.agendafacil.dto.request.ServiceRequest
import com.example.agendafacil.dto.response.ServiceResponse

class ServiceDataSourceImpl: ServiceDataSource {

    override suspend fun getServices(): List<ServiceResponse> {
        return ServiceRepositoryRetrofit.getData().getServices()
    }

    override suspend fun onServiceAdd(serviceRequest: ServiceRequest) {
        ServiceRepositoryRetrofit.getData().serviceAdd(serviceRequest)
    }
}