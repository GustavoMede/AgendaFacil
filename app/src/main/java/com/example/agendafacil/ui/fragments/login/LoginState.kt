package com.example.agendafacil.ui.fragments.login

import com.example.agendafacil.dto.response.LoginResponse

sealed class LoginState {

    object IDLE: LoginState()

    data class onSuccess(val user: LoginResponse): LoginState()

    data class onError(val message: String): LoginState()

    object onLoading: LoginState()
}