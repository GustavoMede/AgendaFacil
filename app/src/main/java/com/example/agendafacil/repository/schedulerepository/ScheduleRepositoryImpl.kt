package com.example.agendafacil.repository.schedulerepository

import com.example.agendafacil.dto.request.ScheduleRequest
import com.example.agendafacil.dto.response.ScheduleResponse
import com.example.agendafacil.repository.datasource.scheduledatasource.ScheduleDataSource

class ScheduleRepositoryImpl(private val datasource: ScheduleDataSource): ScheduleRepository {

    override suspend fun onScheduleService(horaAtendimento: Int, clientId: Int, servicoId: Int) {
        datasource.onSchedule(ScheduleRequest(horaAtendimento, clientId, servicoId))
    }

    override suspend fun onGetSchedules(clienteId: Int): List<ScheduleResponse> {
        return datasource.onGetSchedules(clienteId)
    }
}