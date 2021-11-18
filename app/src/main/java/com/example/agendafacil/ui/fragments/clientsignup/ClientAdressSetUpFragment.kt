package com.example.agendafacil.ui.fragments.clientsignup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.agendafacil.R
import com.example.agendafacil.databinding.ClientAdressSetupFragmentLayoutBinding
import com.example.agendafacil.dto.AdressDTO
import com.example.agendafacil.dto.ClientDTO
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClientAdressSetUpFragment : Fragment() {

    private var bind: ClientAdressSetupFragmentLayoutBinding? = null

    private val args by navArgs<ClientAdressSetUpFragmentArgs>()

    private val clientSignUpViewModel: ClientSignUpViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ClientAdressSetupFragmentLayoutBinding.inflate(layoutInflater, container, false)
            .apply {
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
            it.clientDataSetupFragmentSignUpBtn.setOnClickListener {
                clientSignUpViewModel.createAccount(toDTO())
            }
        }
    }

    private fun toDTO(): ClientDTO {
        return ClientDTO(
            args.name,
            args.email,
            args.document,
            args.password,
            AdressDTO(
                bind!!.clientDataSetupFragmentAdress.text.toString(),
                bind!!.clientDataSetupFragmentNumber.text.toString(),
                bind!!.clientDataSetupFragmentComplement.text.toString(),
                bind!!.clientDataSetupFragmentDistrict.text.toString(),
                bind!!.clientDataSetupFragmentCep.text.toString(),
                bind!!.clientDataSetupFragmentCity.text.toString(),
                bind!!.clientDataSetupFragmentState.text.toString()
            )
        )
    }

    private fun onObserverState() {
        clientSignUpViewModel.clientLiveData.observe(viewLifecycleOwner , Observer {
            when (it) {
                is ClientSignUpState.onLoading -> onLoading()
                is ClientSignUpState.onError -> showError(it.message)
                is ClientSignUpState.onSuccess -> onSuccess(it.message)
            }
        })
    }

    private fun onSuccess(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        findNavController().popBackStack(R.id.homeFragment, false)
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun onLoading() {
    }
}

