package com.example.agendafacil.ui.fragments.professionalsignup

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
import com.example.agendafacil.databinding.ProfessionalAdressSetupFragmentLayoutBinding
import com.example.agendafacil.dto.AdressDTO
import com.example.agendafacil.dto.ProfessionalDTO
import com.example.agendafacil.dto.TimeAvailabilityDTO
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfessionalAdressSetUpFragment: Fragment() {

    private var bind: ProfessionalAdressSetupFragmentLayoutBinding? = null

    private val args by navArgs<ProfessionalAdressSetUpFragmentArgs>()

    private val professionalViewModel: ProfessionalSignUpViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ProfessionalAdressSetupFragmentLayoutBinding.inflate(inflater, container, false).apply {
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
            it.professionalDataSetupFragmentSignUpBtn.setOnClickListener {
                professionalViewModel.createAccount(toDTO())
            }
        }
    }

    private fun toDTO(): ProfessionalDTO {
        return ProfessionalDTO(
            args.name,
            args.email,
            args.document,
            args.password,
            AdressDTO(
                bind!!.professionalDataSetupFragmentAdress.text.toString(),
                bind!!.professionalDataSetupFragmentNumber.text.toString(),
                bind!!.professionalDataSetupFragmentComplement.text.toString(),
                bind!!.professionalDataSetupFragmentDistrict.text.toString(),
                bind!!.professionalDataSetupFragmentCep.text.toString(),
                bind!!.professionalDataSetupFragmentCity.text.toString(),
                bind!!.professionalDataSetupFragmentState.text.toString()),
            TimeAvailabilityDTO(
                args.weekHours,
                args.beginHour,
                args.endHour
            )
        )
    }

    private fun onObserverState() {
        professionalViewModel.clientLiveData.observe(viewLifecycleOwner , Observer {
            when (it) {
                is ProfessionalSignUpState.onLoading -> onLoading()
                is ProfessionalSignUpState.onError -> showError(it.message)
                is ProfessionalSignUpState.onSuccess -> onSuccess(it.message)
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