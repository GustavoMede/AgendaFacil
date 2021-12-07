package com.example.agendafacil.ui.fragments.servicesList

import com.example.agendafacil.dto.response.ServiceResponse

sealed class ServiceListState {

    object IDLE: ServiceListState()

    data class onSuccess(val services: List<ServiceResponse>): ServiceListState()

    data class onError(val message: String): ServiceListState()

    object onLoading: ServiceListState()
}