package com.example.agendafacil.usecase.getschedules

import com.example.agendafacil.dto.response.ScheduleResponse

interface OnGetSchedulesUseCase {

    suspend fun onGetSchedules(clienteId: Int): List<ScheduleResponse>
}