package com.example.agendafacil.dto.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AdressRequest(
    val logradouro: String,
    val numero: String,
    val complemento: String,
    val bairro: String,
    val cep: String,
    val cidade: String,
    val estado: String
) : Parcelable
