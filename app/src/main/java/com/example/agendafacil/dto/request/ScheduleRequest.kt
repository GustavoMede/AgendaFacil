package com.example.agendafacil.dto.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScheduleRequest(
    val horaAtendimento: Int,
    val clienteId: Int,
    val servicoId: Int
) : Parcelable