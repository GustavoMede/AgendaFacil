package com.example.agendafacil.ui.fragments.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agendafacil.usecase.onlogin.OnLoginUseCase
import kotlinx.coroutines.launch

class LoginFragmentViewModel(private val useCase: OnLoginUseCase): ViewModel() {

    private val _loginLiveData = MutableLiveData<LoginState>(LoginState.IDLE)
    val loginLiveData: LiveData<LoginState> get() = _loginLiveData

    fun onLogin(email: String, password: String){
        viewModelScope.launch {
            try {
                _loginLiveData.value = LoginState.onLoading
                val user = useCase.onLogin(email, password)
                _loginLiveData.value  = LoginState.onSuccess(user)
            }catch (e: Exception){
                _loginLiveData.value = LoginState.onError(e.localizedMessage.orEmpty())
            }
        }
    }
}