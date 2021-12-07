package com.example.agendafacil.dto.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ClientRequest(
    val nome: String,
    val email: String,
    val cpfOuCnpj: String,
    val senha: String,
    val endereco: AdressRequest
) : Parcelable