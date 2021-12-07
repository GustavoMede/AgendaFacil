package com.example.agendafacil.dto.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InputRequest(
    val nome: String,
    val descricao: String
) : Parcelable