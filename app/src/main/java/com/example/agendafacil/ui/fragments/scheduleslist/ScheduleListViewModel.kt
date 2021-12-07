package com.example.agendafacil.ui.fragments.scheduleslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agendafacil.ui.fragments.serviceadd.ServiceAddState
import com.example.agendafacil.usecase.getschedules.OnGetSchedulesUseCase
import com.example.agendafacil.usecase.onscheduleserviceusecase.OnScheduleServiceUseCase
import kotlinx.coroutines.launch

class ScheduleListViewModel(private val useCase: OnGetSchedulesUseCase): ViewModel() {

    private val _scheduleListLiveData = MutableLiveData<ScheduleListState>(ScheduleListState.IDLE)

    val scheduleListLiveData: LiveData<ScheduleListState> get() = _scheduleListLiveData

    fun getAllUserSchedules(clienteId: Int){
        viewModelScope.launch {
            try {
                _scheduleListLiveData.value = ScheduleListState.onLoading
                val schedules = useCase.onGetSchedules(clienteId)
                _scheduleListLiveData.value  = ScheduleListState.onSuccess(schedules)
            }catch (e: Exception){
                _scheduleListLiveData.value = ScheduleListState.onError(e.message.orEmpty())
            }
        }
    }
}