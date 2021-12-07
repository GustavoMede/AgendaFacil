package com.example.agendafacil.usecase.servicelistusecase

import com.example.agendafacil.dto.response.ServiceResponse
import com.example.agendafacil.repository.servicerepository.ServiceRepository

class ServiceListUseCaseImpl(val repository: ServiceRepository): ServiceListUseCase {

    override suspend fun getServices(): List<ServiceResponse> {
        return repository.getServices()
    }
}