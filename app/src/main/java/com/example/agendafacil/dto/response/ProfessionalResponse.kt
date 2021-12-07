package com.example.agendafacil.dto.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfessionalResponse(
    val id: Int,
    val nome: String,
    val email: String
) : Parcelable