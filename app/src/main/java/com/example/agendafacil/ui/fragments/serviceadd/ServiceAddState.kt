package com.example.agendafacil.ui.fragments.serviceadd

import com.example.agendafacil.dto.request.InputRequest
import com.example.agendafacil.ui.fragments.professionalsignup.ProfessionalSignUpState

sealed class ServiceAddState {

    object IDLE: ServiceAddState()

    data class onListLoaded(val inputs: List<InputRequest>): ServiceAddState()

    data class onServiceAdded(val message: String): ServiceAddState()

    data class onError(val message: String): ServiceAddState()

    object onInputListCleared: ServiceAddState()

    object onLoading: ServiceAddState()
}