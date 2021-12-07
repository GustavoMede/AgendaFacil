package com.example.agendafacil.ui.fragments.scheduleslist

import com.example.agendafacil.dto.response.ScheduleResponse

sealed class ScheduleListState {

    object IDLE: ScheduleListState()

    data class onSuccess(val schedules: List<ScheduleResponse>): ScheduleListState()

    data class onError(val message: String): ScheduleListState()

    object onLoading: ScheduleListState()
}