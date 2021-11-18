package com.example.agendafacil.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TimeAvailabilityDTO(
    val horasSemanais: String,
    val horaInicio: String,
    val horaTermino: String
) : Parcelable {
}