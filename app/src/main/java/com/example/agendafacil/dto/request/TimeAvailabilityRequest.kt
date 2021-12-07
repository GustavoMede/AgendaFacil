package com.example.agendafacil.dto.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TimeAvailabilityRequest(
    val horasSemanais: String,
    val horaInicio: String,
    val horaTermino: String
) : Parcelable {
}