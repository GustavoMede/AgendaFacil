package com.example.agendafacil.ui.fragments.clientsignup

sealed class ClientSignUpState {

    object IDLE: ClientSignUpState()

    data class onSuccess(val message: String): ClientSignUpState()

    data class onError(val message: String): ClientSignUpState()

    object onLoading: ClientSignUpState()
}