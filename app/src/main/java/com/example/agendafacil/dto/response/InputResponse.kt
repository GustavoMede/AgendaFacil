package com.example.agendafacil.dto.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InputResponse(
    val id: Int,
    val nome: String,
    val descricao: String
) : Parcelable {

}
