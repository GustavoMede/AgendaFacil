package com.example.agendafacil.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.agendafacil.databinding.HomeFragmentLayoutBinding
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationUtils
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import com.example.agendafacil.R
import androidx.appcompat.app.AppCompatActivity
import com.example.agendafacil.ui.MainActivity


class HomeFragment : Fragment() {

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

    override fun onDestroyView() {
        bind = null
        super.onDestroyView()
    }

    private fun onClickListener() {
        bind?.let {
            it.homeActivityCadastroClienteBtn.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToClientDataSetUpFragment())
            }
            it.homeActivityCadastroProfissionalBtn.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToProfessionalDataSetUpFragment())
            }
            it.homeActivityLoginBtn.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLoginFragment())
            }
        }
    }
}