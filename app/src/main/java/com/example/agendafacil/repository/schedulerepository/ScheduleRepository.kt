package com.example.agendafacil.repository.schedulerepository

import com.example.agendafacil.dto.response.ScheduleResponse

interface ScheduleRepository {

    suspend fun onScheduleService(horaAtendimento: Int, clientId: Int, servicoId: Int)

    suspend fun onGetSchedules(clienteId: Int): List<ScheduleResponse>
}