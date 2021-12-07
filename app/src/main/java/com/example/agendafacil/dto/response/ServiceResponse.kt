package com.example.agendafacil.dto.response

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class ServiceResponse(
    val id: Int,
    val nome: String,
    val tipoLocal: String,
    val tipoTrabalho: String,
    val valor: Double,
    @Json(name = "endereco") val address: AdressResponse,
    val insumos: List<InputResponse>,
    @Json(name = "profissional") val professional: ProfessionalResponse
) : Parcelable {
}