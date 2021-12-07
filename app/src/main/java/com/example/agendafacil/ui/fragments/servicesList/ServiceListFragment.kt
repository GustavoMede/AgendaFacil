package com.example.agendafacil.ui.fragments.servicesList

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.agendafacil.R
import com.example.agendafacil.databinding.ServiceListFragmentLayoutBinding
import com.example.agendafacil.dto.response.ServiceResponse
import com.google.android.material.navigation.NavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class ServiceListFragment : Fragment(), NavigationView.OnNavigationItemSelectedListener {

    private var bind: ServiceListFragmentLayoutBinding? = null

    private val args by navArgs<ServiceListFragmentArgs>()

    private val serviceViewModel: ServiceListViewModel by viewModel()

    private var drawer: DrawerLayout? = null

    private val serviceAdapter by lazy {
        ServiceListFragmentAdapter(oneServiceSelected)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ServiceListFragmentLayoutBinding.inflate(inflater, container, false).apply {
            bind = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureMenu()
        onObserverState()
        serviceViewModel.getServices()
    }

    override fun onDestroyView() {
        bind = null
        super.onDestroyView()
    }

    override fun onResume() {
        super.onResume()
        configureToolbar()
    }

    override fun onStop() {
        super.onStop()
        drawer = null
        val activity = (activity as AppCompatActivity)
        activity.supportActionBar?.show()
    }

    private val oneServiceSelected = object : ServiceListener {
        override fun invoke(service: ServiceResponse) {
            findNavController().navigate(ServiceListFragmentDirections.actionServiceListFragmentToScheduleServiceFragment(service, args.user.id))
        }
    }

    private fun onObserverState() {
        serviceViewModel.serviceLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ServiceListState.onLoading -> onLoading()
                is ServiceListState.onError -> showError(it.message)
                is ServiceListState.onSuccess -> onSuccess(it.services)
            }
        })
    }

    private fun onSuccess(services: List<ServiceResponse>) {
        serviceAdapter.submitList(services)
        setRecyclerView(serviceAdapter)
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun onLoading() {
    }

    private fun setRecyclerView(serviceAdapter: ServiceListFragmentAdapter) {
        bind?.let {
            it.serviceListFragmentRecyclerview.run {
                setHasFixedSize(true)
                layoutManager =
                    GridLayoutManager(requireContext(), 1, GridLayoutManager.VERTICAL, false)
                adapter = serviceAdapter
            }
        }
    }

    private fun configureToolbar() {
        val activity = (activity as AppCompatActivity)
        activity.supportActionBar?.hide()
        drawer = bind?.serviceListFragmentDrawerLayout
        val toggle = ActionBarDrawerToggle(
            requireActivity(),
            drawer,
            bind?.serviceListFragmentToolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        toggle.isDrawerSlideAnimationEnabled = true
        drawer?.addDrawerListener(toggle)
        toggle.syncState()
        bind?.navView?.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_sign_out -> {
                drawer?.close()
                findNavController().popBackStack(R.id.homeFragment, false)
            }
            R.id.nav_service_add -> {
                drawer?.close()
                findNavController().navigate(ServiceListFragmentDirections.actionServiceListFragmentToServiceAddFragment(args.user.id))
            }
            R.id.nav_schedule_list -> {
                drawer?.close()
                findNavController().navigate(ServiceListFragmentDirections.actionServiceListFragmentToScheduleListFragment(args.user.id))
            }
        }
        return true
    }

    private fun configureMenu() {
        if (!args.user.ehTrabalhador) bind?.navView?.menu?.findItem(R.id.nav_service_add)?.isVisible = false
        if (args.user.ehTrabalhador) bind?.navView?.menu?.findItem(R.id.nav_schedule_list)?.isVisible = false
    }
}