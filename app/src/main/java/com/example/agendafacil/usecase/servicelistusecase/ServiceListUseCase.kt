package com.example.agendafacil.usecase.servicelistusecase

import com.example.agendafacil.dto.response.ServiceResponse

interface ServiceListUseCase {

    suspend fun getServices(): List<ServiceResponse>
}