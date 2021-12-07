package com.example.agendafacil.usecase.onserviceaddusecase

import com.example.agendafacil.dto.request.ServiceRequest

interface OnServiceAddUseCase {

    suspend fun onServiceAdd(serviceRequest: ServiceRequest)
}