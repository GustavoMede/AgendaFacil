package com.example.agendafacil.repository.datasource.scheduledatasource

import com.example.agendafacil.dto.request.ScheduleRequest
import com.example.agendafacil.dto.response.ScheduleResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ScheduleApiService {

    @POST("/clientes/agendamento")
    suspend fun scheduleService(@Body scheduleRequest: ScheduleRequest)

    @GET("/clientes/agendamentos/{id}")
    suspend fun getSchedules(@Path(value = "id") id: Int): List<ScheduleResponse>
}