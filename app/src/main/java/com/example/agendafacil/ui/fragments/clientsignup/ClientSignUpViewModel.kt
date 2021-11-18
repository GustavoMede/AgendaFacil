package com.example.agendafacil.ui.fragments.clientsignup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agendafacil.dto.ClientDTO
import com.example.agendafacil.usecase.onclientsignup.OnClientSignUpUseCase
import kotlinx.coroutines.launch
import java.lang.Exception

class ClientSignUpViewModel(private val useCase: OnClientSignUpUseCase): ViewModel() {

    private val _clientLiveData = MutableLiveData<ClientSignUpState>(ClientSignUpState.IDLE)

    val clientLiveData: LiveData<ClientSignUpState> get() = _clientLiveData

    fun createAccount(clientDTO: ClientDTO){
        viewModelScope.launch {
            try {
                _clientLiveData.value = ClientSignUpState.onLoading
                useCase.onCreateAccount(clientDTO)
                _clientLiveData.value  = ClientSignUpState.onSuccess("User successfully signed up.")
            }catch (e: Exception){
                _clientLiveData.value = ClientSignUpState.onError(e.message.orEmpty())
            }
        }
    }
}