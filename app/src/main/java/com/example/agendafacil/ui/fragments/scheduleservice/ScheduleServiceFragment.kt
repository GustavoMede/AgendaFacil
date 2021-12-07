package com.example.agendafacil.ui.fragments.scheduleservice

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
import androidx.navigation.fragment.navArgs
import com.example.agendafacil.databinding.ScheduleServiceFragmentLayoutBinding
import com.example.agendafacil.ui.fragments.serviceadd.ServiceAddState
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScheduleServiceFragment: Fragment() {

    private var bind: ScheduleServiceFragmentLayoutBinding? = null

    private val args by navArgs<ScheduleServiceFragmentArgs>()

    private val scheduleViewModel: ScheduleServiceViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ScheduleServiceFragmentLayoutBinding.inflate(inflater, container, false).apply {
            bind = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind?.let {
            it.service = args.service
        }
        onClickListener()
        onObserverState()
    }

    private fun onClickListener() {
        bind?.let {
            it.scheduleServiceContinueBtn.setOnClickListener { btn ->
                val horaAtendimento = it.scheduleServiceScheduleHour.text.toString().toInt()
                scheduleViewModel.onScheduleService(horaAtendimento, args.clientId, args.service.id)
            }
        }
    }

    private fun onObserverState() {
        scheduleViewModel.scheduleLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ScheduleServiceState.onLoading -> onLoading()
                is ScheduleServiceState.onError -> showError(it.message)
                is ScheduleServiceState.onSuccess -> onSucess()
            }
        })
    }

    private fun onSucess() {
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