package com.example.agendafacil.ui.fragments.login

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.agendafacil.databinding.LoginFragmentLayoutBinding
import com.example.agendafacil.dto.response.LoginResponse
import com.example.agendafacil.ui.fragments.professionalsignup.ProfessionalSignUpState
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment: Fragment() {

    private var bind: LoginFragmentLayoutBinding? = null
    private val loginViewModel: LoginFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return LoginFragmentLayoutBinding.inflate(inflater, container, false).apply {
            bind = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListener()
        onObserverState()
    }

    private fun onClickListener() {
        bind?.let {
            it.loginFragmentLoginBtn.setOnClickListener { btn ->
                val email = it.loginFragmentEmail.text.toString()
                val password = it.loginFragmentPassword.text.toString()
                loginViewModel.onLogin(email, password)
            }
        }
    }

    private fun onObserverState() {
        loginViewModel.loginLiveData.observe(viewLifecycleOwner, Observer {
            when(it){
                is LoginState.onLoading -> onLoading()
                is LoginState.onError -> showError(it.message)
                is LoginState.onSuccess -> onSuccess(it.user)
            }
        })
    }

    private fun onSuccess(user: LoginResponse) {
        Toast.makeText(requireContext(), "Seja bem vindo de volta!", Toast.LENGTH_SHORT).show()
        hideKeyboardFrom(requireContext(), requireView())
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToServiceListFragment(user))
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun onLoading() {
    }

    fun hideKeyboardFrom(context: Context, view: View) {
        val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}