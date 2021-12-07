package com.example.agendafacil.usecase.onscheduleserviceusecase

import com.example.agendafacil.repository.schedulerepository.ScheduleRepository

class OnScheduleServiceUseCaseImpl(private val repository: ScheduleRepository): OnScheduleServiceUseCase {

    override suspend fun onSchedule(horaAtendimento: Int, clientId: Int, servicoId: Int) {
        repository.onScheduleService(horaAtendimento, clientId, servicoId)
    }
}