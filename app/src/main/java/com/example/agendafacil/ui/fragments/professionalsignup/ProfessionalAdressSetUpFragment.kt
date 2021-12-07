package com.example.agendafacil.ui.fragments.professionalsignup

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.agendafacil.R
import com.example.agendafacil.databinding.ProfessionalAdressSetupFragmentLayoutBinding
import com.example.agendafacil.dto.request.AdressRequest
import com.example.agendafacil.dto.request.ProfessionalRequest
import com.example.agendafacil.dto.request.TimeAvailabilityRequest
import com.example.agendafacil.dto.response.ProfessionalResponse
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.app.Activity




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

    override fun onDestroyView() {
        bind = null
        super.onDestroyView()
    }

    private fun onClickListener() {
        bind?.let {
            it.professionalDataSetupFragmentSignUpBtn.setOnClickListener {
                professionalViewModel.createAccount(toDTO())
            }
        }
    }

    private fun toDTO(): ProfessionalRequest {
        return ProfessionalRequest(
            args.name,
            args.email,
            args.document,
            args.password,
            AdressRequest(
                bind!!.professionalDataSetupFragmentAdress.text.toString(),
                bind!!.professionalDataSetupFragmentNumber.text.toString(),
                bind!!.professionalDataSetupFragmentComplement.text.toString(),
                bind!!.professionalDataSetupFragmentDistrict.text.toString(),
                bind!!.professionalDataSetupFragmentCep.text.toString(),
                bind!!.professionalDataSetupFragmentCity.text.toString(),
                bind!!.professionalDataSetupFragmentState.text.toString()),
            TimeAvailabilityRequest(
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
        hideKeyboardFrom(requireContext(), requireView())
        findNavController().popBackStack(R.id.homeFragment, false)
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