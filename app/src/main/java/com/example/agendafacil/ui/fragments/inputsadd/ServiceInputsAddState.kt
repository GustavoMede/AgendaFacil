package com.example.agendafacil.ui.fragments.inputsadd

import com.example.agendafacil.dto.response.LoginResponse
import com.example.agendafacil.ui.fragments.login.LoginState

sealed class ServiceInputsAddState {

    object IDLE: ServiceInputsAddState()

    object onSuccess: ServiceInputsAddState()

    data class onError(val message: String): ServiceInputsAddState()

    object onLoading: ServiceInputsAddState()
}