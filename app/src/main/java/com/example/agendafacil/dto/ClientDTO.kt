package com.example.agendafacil.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ClientDTO(
    val nome: String,
    val email: String,
    val cpfOuCnpj: String,
    val senha: String,
    val endereco: AdressDTO
) : Parcelable