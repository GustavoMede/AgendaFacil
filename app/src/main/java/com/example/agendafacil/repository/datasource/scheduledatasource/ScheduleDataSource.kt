package com.example.agendafacil.repository.datasource.scheduledatasource

import com.example.agendafacil.dto.request.ScheduleRequest
import com.example.agendafacil.dto.response.ScheduleResponse

interface ScheduleDataSource {

    suspend fun onSchedule(scheduleRequest: ScheduleRequest)

    suspend fun onGetSchedules(clienteId: Int): List<ScheduleResponse>
}