package com.example.agendafacil.ui.fragments.scheduleservice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agendafacil.usecase.onscheduleserviceusecase.OnScheduleServiceUseCase
import kotlinx.coroutines.launch

class ScheduleServiceViewModel(private val useCase: OnScheduleServiceUseCase): ViewModel() {

    private val _scheduleLiveData = MutableLiveData<ScheduleServiceState>(ScheduleServiceState.IDLE)

    val scheduleLiveData: LiveData<ScheduleServiceState> get() = _scheduleLiveData

    fun onScheduleService(horaAtendimento: Int, clientId: Int, servicoId: Int){
        viewModelScope.launch {
            try {
                _scheduleLiveData.value = ScheduleServiceState.onLoading
                useCase.onSchedule(horaAtendimento, clientId, servicoId)
                _scheduleLiveData.value  = ScheduleServiceState.onSuccess
            }catch (e: Exception){
                _scheduleLiveData.value = ScheduleServiceState.onError(e.message.orEmpty())
            }
        }
    }
}