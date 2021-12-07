package com.example.agendafacil.ui.fragments.serviceadd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agendafacil.dto.request.InputRequest
import com.example.agendafacil.dto.request.ServiceRequest
import com.example.agendafacil.usecase.getinputsusecase.OnGetInputsUseCase
import com.example.agendafacil.usecase.onclearinputlistusecase.OnClearInputListUseCase
import com.example.agendafacil.usecase.onserviceaddusecase.OnServiceAddUseCase
import kotlinx.coroutines.launch

class ServiceAddViewModel(private val getInputsUseCase: OnGetInputsUseCase,
                          private val onServiceAddUseCase: OnServiceAddUseCase,
                          private val onClearInputListUseCase: OnClearInputListUseCase): ViewModel() {

    private val _serviceLiveData = MutableLiveData<ServiceAddState>(ServiceAddState.IDLE)

    val serviceLiveData: LiveData<ServiceAddState> get() = _serviceLiveData

    fun getAllInputs(){
        viewModelScope.launch {
            try {
                _serviceLiveData.value = ServiceAddState.onLoading
                val inputs = getInputsUseCase.getInputs()
                _serviceLiveData.value  = ServiceAddState.onListLoaded(inputs)
            }catch (e: Exception){
                _serviceLiveData.value = ServiceAddState.onError(e.message.orEmpty())
            }
        }
    }

    fun onServiceAdd(serviceRequest: ServiceRequest){
        viewModelScope.launch {
            try {
                _serviceLiveData.value = ServiceAddState.onLoading
                onServiceAddUseCase.onServiceAdd(serviceRequest)
                _serviceLiveData.value  = ServiceAddState.onServiceAdded("Serviço adicionado com sucesso!")
            }catch (e: Exception){
                _serviceLiveData.value = ServiceAddState.onError(e.message.orEmpty())
            }
        }
    }

    fun clearInputList() {
        viewModelScope.launch {
            try {
                _serviceLiveData.value = ServiceAddState.onLoading
                onClearInputListUseCase.onClearInputList()
                _serviceLiveData.value  = ServiceAddState.onInputListCleared
            }catch (e: Exception){
                _serviceLiveData.value = ServiceAddState.onError(e.message.orEmpty())
            }
        }
    }
}