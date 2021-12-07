package com.example.agendafacil.dto.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginResponse(
    val id: Int,
    val email: String,
    val nome: String,
    val ehTrabalhador: Boolean
) : Parcelable