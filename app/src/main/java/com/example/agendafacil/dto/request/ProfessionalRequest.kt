package com.example.agendafacil.dto.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfessionalRequest(
    val nome: String,
    val email: String,
    val cpfOuCnpj: String,
    val senha: String,
    val endereco: AdressRequest,
    val disponibilidadeHoraria: TimeAvailabilityRequest
) : Parcelable {
}