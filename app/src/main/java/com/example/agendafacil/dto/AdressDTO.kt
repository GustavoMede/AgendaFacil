package com.example.agendafacil.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AdressDTO(
    val logradouro: String,
    val numero: String,
    val complemento: String,
    val bairro: String,
    val cep: String,
    val cidade: String,
    val estado: String
) : Parcelable
