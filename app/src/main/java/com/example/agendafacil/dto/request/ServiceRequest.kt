package com.example.agendafacil.dto.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ServiceRequest(
    val nome: String,
    val tipoLocal: String,
    val tipoTrabalho: String,
    val valor: Double,
    val insumos: List<InputRequest>,
    val idProfissional: Int
) : Parcelable {
}