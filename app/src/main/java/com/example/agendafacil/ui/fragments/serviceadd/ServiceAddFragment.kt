package com.example.agendafacil.ui.fragments.serviceadd

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.agendafacil.R
import com.example.agendafacil.databinding.ServiceAddFragmentLayoutBinding
import com.example.agendafacil.dto.request.InputRequest
import com.example.agendafacil.dto.request.ServiceRequest
import org.koin.androidx.viewmodel.ext.android.viewModel


class ServiceAddFragment : Fragment() {

    private var bind: ServiceAddFragmentLayoutBinding? = null

    private val args by navArgs<ServiceAddFragmentArgs>()

    private var localInputs = mutableListOf<InputRequest>()

    private val serviceAddViewModel: ServiceAddViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = ServiceAddFragmentLayoutBinding.inflate(inflater, container, false)
        return bind!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListener()
        onObserverState()
    }

    override fun onResume() {
        super.onResume()
        configDropDownMenu()
        serviceAddViewModel.getAllInputs()
    }

    override fun onDestroyView() {
        bind = null
        super.onDestroyView()
    }

    private fun configDropDownMenu() {
        val locations = resources.getStringArray(R.array.locations)
        val periods = resources.getStringArray(R.array.periods)
        val locationsArrayAdapter =
            ArrayAdapter(requireContext(), R.layout.dropdown_item, locations)
        val periodsArrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, periods)
        bind?.serviceAddFragmentLocationsList?.setAdapter(locationsArrayAdapter)
        bind?.serviceAddFragmentPeriodList?.setAdapter(periodsArrayAdapter)
    }

    private fun onClickListener() {
        bind?.let {
            it.serviceAddFragmentNextBtn.setOnClickListener { btn ->
                val nome = it.serviceAddFragmentServiceName.text.toString()
                val tipoLocal = it.serviceAddFragmentLocationsList.text.toString().replace("\\s".toRegex(), "").uppercase()
                val tipoTrabalho = it.serviceAddFragmentPeriodList.text.toString().replace("\\s".toRegex(), "").uppercase()
                val valor = it.serviceAddFragmentPrice.text.toString().toDouble()
                val insumos = localInputs
                val idProfissional = args.professionalId
                serviceAddViewModel.onServiceAdd(ServiceRequest(nome, tipoLocal, tipoTrabalho,
                valor, insumos, idProfissional))
            }
            it.serviceAddFragmentAddInputBtn.setOnClickListener {
                hideKeyboardFrom(requireContext(), requireView())
                findNavController().navigate(ServiceAddFragmentDirections.actionServiceAddFragmentToServiceInputsAddFragment())
            }
        }
    }

    private fun onObserverState() {
        serviceAddViewModel.serviceLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ServiceAddState.onLoading -> onLoading()
                is ServiceAddState.onError -> showError(it.message)
                is ServiceAddState.onListLoaded -> onListLoaded(it.inputs)
                is ServiceAddState.onServiceAdded -> onServiceAdded(it.message)
                is ServiceAddState.onInputListCleared -> onInputListCleared()
            }
        })
    }

    private fun onInputListCleared() {
        findNavController().popBackStack()
    }

    private fun onServiceAdded(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        hideKeyboardFrom(requireContext(), requireView())
        serviceAddViewModel.clearInputList()
    }

    private fun onListLoaded(inputs: List<InputRequest>) {
        localInputs.clear()
        localInputs.addAll(inputs)
        bind?.let {
            it.serviceAddFragmentRecyclerView.adapter = ServiceInputsAdapter(
                inputs
            )
        }
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