package com.example.agendafacil.ui.fragments.servicesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agendafacil.dto.request.ProfessionalRequest
import com.example.agendafacil.dto.response.ServiceResponse
import com.example.agendafacil.ui.fragments.professionalsignup.ProfessionalSignUpState
import com.example.agendafacil.usecase.servicelistusecase.ServiceListUseCase
import kotlinx.coroutines.launch

class ServiceListViewModel(val useCase: ServiceListUseCase): ViewModel() {

    private val _serviceLiveData = MutableLiveData<ServiceListState>(ServiceListState.IDLE)

    val serviceLiveData: LiveData<ServiceListState> get() = _serviceLiveData

    fun getServices(){
        viewModelScope.launch {
            try {
                _serviceLiveData.value = ServiceListState.onLoading
                val services = useCase.getServices()
                _serviceLiveData.value = ServiceListState.onSuccess(services)
            }catch (e: Exception){
                _serviceLiveData.value = ServiceListState.onError(e.message.orEmpty())
            }
        }
    }
}