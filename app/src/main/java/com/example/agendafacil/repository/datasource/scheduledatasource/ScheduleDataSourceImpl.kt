package com.example.agendafacil.repository.datasource.scheduledatasource

import com.example.agendafacil.dto.request.ScheduleRequest
import com.example.agendafacil.dto.response.ScheduleResponse

class ScheduleDataSourceImpl: ScheduleDataSource {

    override suspend fun onSchedule(scheduleRequest: ScheduleRequest) {
        ScheduleRepositoryRetrofit.sendRequest().scheduleService(scheduleRequest)
    }

    override suspend fun onGetSchedules(clienteId: Int): List<ScheduleResponse> {
        return ScheduleRepositoryRetrofit.sendRequest().getSchedules(clienteId)
    }
}