package com.example.agendafacil.ui.fragments.inputsadd

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
import com.example.agendafacil.databinding.ServiceInputsAddFragmentLayoutBinding
import com.example.agendafacil.ui.fragments.login.LoginState
import com.example.agendafacil.ui.fragments.servicesList.ServiceListState
import org.koin.androidx.viewmodel.ext.android.viewModel

class ServiceInputsAddFragment: Fragment() {

    private var bind: ServiceInputsAddFragmentLayoutBinding? = null

    private val inputViewModel: ServiceInputsAddViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ServiceInputsAddFragmentLayoutBinding.inflate(inflater, container, false).apply {
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
            it.serviceInputsAddFragmentNextBtn.setOnClickListener { btn ->
                val nome = it.serviceInputsAddFragmentInputName.text.toString()
                val descricao = it.serviceInputsAddFragmentInputDescription.text.toString()
                inputViewModel.onInputAdd(nome, descricao)
            }
        }
    }

    private fun onObserverState() {
        inputViewModel.inputsAddLiveData.observe(viewLifecycleOwner, Observer {
            when(it){
                is ServiceInputsAddState.onLoading -> onLoading()
                is ServiceInputsAddState.onError -> showError(it.message)
                is ServiceInputsAddState.onSuccess -> onSuccess()
            }
        })
    }

    private fun onSuccess() {
        hideKeyboardFrom(requireContext(), requireView())
        findNavController().popBackStack()
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