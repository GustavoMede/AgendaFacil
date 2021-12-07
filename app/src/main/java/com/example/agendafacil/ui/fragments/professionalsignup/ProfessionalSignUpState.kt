package com.example.agendafacil.ui.fragments.professionalsignup

sealed class ProfessionalSignUpState {

    object IDLE: ProfessionalSignUpState()

    data class onSuccess(val message: String): ProfessionalSignUpState()

    data class onError(val message: String): ProfessionalSignUpState()

    object onLoading: ProfessionalSignUpState()
}