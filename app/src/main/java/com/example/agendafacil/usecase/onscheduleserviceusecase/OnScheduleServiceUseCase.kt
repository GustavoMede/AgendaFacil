package com.example.agendafacil.usecase.onscheduleserviceusecase

interface OnScheduleServiceUseCase {

    suspend fun onSchedule(horaAtendimento: Int, clientId: Int, servicoId: Int)
}