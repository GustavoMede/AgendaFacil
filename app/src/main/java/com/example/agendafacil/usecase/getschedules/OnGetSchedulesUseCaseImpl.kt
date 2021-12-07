package com.example.agendafacil.usecase.getschedules

import com.example.agendafacil.dto.response.ScheduleResponse
import com.example.agendafacil.repository.schedulerepository.ScheduleRepository

class OnGetSchedulesUseCaseImpl(private val repository: ScheduleRepository): OnGetSchedulesUseCase {

    override suspend fun onGetSchedules(clienteId: Int): List<ScheduleResponse> {
       return repository.onGetSchedules(clienteId)
    }
}