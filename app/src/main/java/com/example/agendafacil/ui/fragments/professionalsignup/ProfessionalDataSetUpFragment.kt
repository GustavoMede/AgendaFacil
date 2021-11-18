package com.example.agendafacil.ui.fragments.professionalsignup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.agendafacil.databinding.ProfessionalDataSetupFragmentLayoutBinding

class ProfessionalDataSetUpFragment: Fragment() {

    private var bind: ProfessionalDataSetupFragmentLayoutBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ProfessionalDataSetupFragmentLayoutBinding.inflate(inflater, container, false).apply {
            bind = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListener()
    }

    private fun onClickListener() {
        bind?.let {
            it.professionalDataSetupNextBtn.setOnClickListener {
                findNavController().navigate(ProfessionalDataSetUpFragmentDirections.actionProfessionalDataSetUpFragmentToProfessionalAdressSetUpFragment(
                    bind!!.professionalDataSetupName.text.toString(),
                    bind!!.professionalDataSetupFragmentEmail.text.toString(),
                    bind!!.professionalDataSetupFragmentDocument.text.toString(),
                    bind!!.professionalDataSetupFragmentPassword.text.toString(),
                    bind!!.professionalDataSetupFragmentWeekHours.text.toString(),
                    bind!!.professionalDataSetupFragmentBeginHour.text.toString(),
                    bind!!.professionalDataSetupFragmentEndHour.text.toString()
                ))
            }
        }
    }
}