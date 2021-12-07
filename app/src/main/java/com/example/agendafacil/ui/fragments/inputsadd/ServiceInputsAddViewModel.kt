package com.example.agendafacil.ui.fragments.inputsadd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agendafacil.ui.fragments.login.LoginState
import com.example.agendafacil.usecase.inputaddusecase.OnInputAddUseCase
import kotlinx.coroutines.launch

class ServiceInputsAddViewModel(private val useCase: OnInputAddUseCase): ViewModel() {

    private val _inputsAddLiveData = MutableLiveData<ServiceInputsAddState>(ServiceInputsAddState.IDLE)
    val inputsAddLiveData: LiveData<ServiceInputsAddState> get() = _inputsAddLiveData

    fun onInputAdd(nome: String, descricao: String){
        viewModelScope.launch {
            try {
                _inputsAddLiveData.value = ServiceInputsAddState.onLoading
                useCase.onInputAdd(nome, descricao)
                _inputsAddLiveData.value  = ServiceInputsAddState.onSuccess
            }catch (e: Exception){
                _inputsAddLiveData.value = ServiceInputsAddState.onError(e.message.orEmpty())
            }
        }
    }
}