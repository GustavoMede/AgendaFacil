package com.example.agendafacil.usecase.onserviceaddusecase

import com.example.agendafacil.dto.request.ServiceRequest
import com.example.agendafacil.repository.servicerepository.ServiceRepository

class OnServiceAddUseCaseImpl(private val repository: ServiceRepository): OnServiceAddUseCase {

    override suspend fun onServiceAdd(serviceRequest: ServiceRequest) {
        repository.onServiceAdd(serviceRequest)
    }
}