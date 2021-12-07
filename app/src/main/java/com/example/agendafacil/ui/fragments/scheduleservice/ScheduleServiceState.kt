package com.example.agendafacil.ui.fragments.scheduleservice

sealed class ScheduleServiceState {

    object IDLE: ScheduleServiceState()

    data class onError(val message: String): ScheduleServiceState()

    object onSuccess: ScheduleServiceState()

    object onLoading: ScheduleServiceState()
}