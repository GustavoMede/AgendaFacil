package com.example.agendafacil.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.agendafacil.databinding.HomeFragmentLayoutBinding

class HomeFragment: Fragment() {

    private var bind: HomeFragmentLayoutBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return HomeFragmentLayoutBinding.inflate(inflater, container, false).apply {
            bind = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListener()
    }

    private fun onClickListener() {
        bind?.let {
            it.homeActivityCadastroClienteBtn.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToClientDataSetUpFragment())
            }
            it.homeActivityCadastroProfissionalBtn.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToProfessionalDataSetUpFragment())
            }
        }
    }

}