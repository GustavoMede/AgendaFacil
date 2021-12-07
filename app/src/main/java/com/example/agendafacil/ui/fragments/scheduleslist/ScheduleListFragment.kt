package com.example.agendafacil.ui.fragments.scheduleslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.agendafacil.databinding.ScheduleListFragmentLayoutBinding
import com.example.agendafacil.dto.response.ScheduleResponse
import com.example.agendafacil.ui.fragments.servicesList.ServiceListFragmentAdapter
import com.example.agendafacil.ui.fragments.servicesList.ServiceListState
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScheduleListFragment: Fragment() {

    private var bind: ScheduleListFragmentLayoutBinding? = null

    private val args by navArgs<ScheduleListFragmentArgs>()

    private val scheduleListViewModel: ScheduleListViewModel by viewModel()

    private val scheduleAdapter by lazy {
        ScheduleListFragmentAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ScheduleListFragmentLayoutBinding.inflate(inflater, container, false).apply {
            bind = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scheduleListViewModel.getAllUserSchedules(args.clienteId)
        onObserverState()
    }

    private fun onObserverState() {
        scheduleListViewModel.scheduleListLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ScheduleListState.onLoading -> onLoading()
                is ScheduleListState.onError -> showError(it.message)
                is ScheduleListState.onSuccess -> onSuccess(it.schedules)
            }
        })
    }

    private fun onSuccess(schedules: List<ScheduleResponse>) {
        scheduleAdapter.submitList(schedules)
        setRecyclerView(scheduleAdapter)
    }

    private fun setRecyclerView(scheduleAdapter: ScheduleListFragmentAdapter) {
        bind?.let {
            it.scheduleListFragmentRecyclerView.run {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.VERTICAL, false)
                adapter = scheduleAdapter
            }
        }
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun onLoading() {

    }
}