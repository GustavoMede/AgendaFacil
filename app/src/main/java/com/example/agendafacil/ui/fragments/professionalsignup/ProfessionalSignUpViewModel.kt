package com.example.agendafacil.ui.fragments.professionalsignup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agendafacil.dto.ProfessionalDTO
import com.example.agendafacil.usecase.onprofessionalsignup.OnProfessionalSignUpUseCase
import kotlinx.coroutines.launch

class ProfessionalSignUpViewModel(private val useCase: OnProfessionalSignUpUseCase): ViewModel() {

    private val _clientLiveData = MutableLiveData<ProfessionalSignUpState>(ProfessionalSignUpState.IDLE)

    val clientLiveData: LiveData<ProfessionalSignUpState> get() = _clientLiveData

    fun createAccount(professionalDTO: ProfessionalDTO){
        viewModelScope.launch {
            try {
                _clientLiveData.value = ProfessionalSignUpState.onLoading
                useCase.onCreateAccount(professionalDTO)
                _clientLiveData.value  = ProfessionalSignUpState.onSuccess("User successfully signed up.")
            }catch (e: Exception){
                _clientLiveData.value = ProfessionalSignUpState.onError(e.message.orEmpty())
            }
        }
    }

}