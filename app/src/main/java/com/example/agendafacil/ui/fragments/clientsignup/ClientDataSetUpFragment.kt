package com.example.agendafacil.ui.fragments.clientsignup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.agendafacil.databinding.ClientDataSetupFragmentLayoutBinding
import com.example.agendafacil.dto.ClientDTO

class ClientDataSetUpFragment : Fragment() {

    private var bind: ClientDataSetupFragmentLayoutBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ClientDataSetupFragmentLayoutBinding.inflate(inflater, container, false).apply {
            bind = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListener()
    }

    private fun onClickListener() {
        bind?.let {
            it.clientDataSetupNextBtn.setOnClickListener {
                findNavController().navigate(
                    ClientDataSetUpFragmentDirections.actionClientDataSetUpFragmentToClientAdressSetUpFragment(
                        bind!!.clientDataSetupName.text.toString(),
                        bind!!.clientDataSetupFragmentEmail.text.toString(),
                        bind!!.clientDataSetupFragmentDocument.text.toString(),
                        bind!!.clientDataSetupFragmentPassword.text.toString(),
                    )
                )
            }
        }
    }
}