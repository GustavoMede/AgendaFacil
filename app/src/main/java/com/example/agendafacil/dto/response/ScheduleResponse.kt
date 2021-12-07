package com.example.agendafacil.dto.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScheduleResponse(
    val horaAtendimento: Int,
    val servico: ServiceResponse
) : Parcelable {
}