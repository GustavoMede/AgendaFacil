package com.example.agendafacil.ui.fragments.professionalsignup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agendafacil.dto.request.ProfessionalRequest
import com.example.agendafacil.usecase.onprofessionalsignup.OnProfessionalSignUpUseCase
import kotlinx.coroutines.launch

class ProfessionalSignUpViewModel(private val useCase: OnProfessionalSignUpUseCase): ViewModel() {

    private val _clientLiveData = MutableLiveData<ProfessionalSignUpState>(ProfessionalSignUpState.IDLE)

    val clientLiveData: LiveData<ProfessionalSignUpState> get() = _clientLiveData

    fun createAccount(professionalRequest: ProfessionalRequest){
        viewModelScope.launch {
            try {
                _clientLiveData.value = ProfessionalSignUpState.onLoading
                val user = useCase.onCreateAccount(professionalRequest)
                _clientLiveData.value  = ProfessionalSignUpState.onSuccess("Conta criada com sucesso!")
            }catch (e: Exception){
                _clientLiveData.value = ProfessionalSignUpState.onError(e.message.orEmpty())
            }
        }
    }

}