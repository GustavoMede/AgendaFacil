package com.example.agendafacil.ui.fragments.servicesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.agendafacil.databinding.ServiceItemLayoutBinding
import com.example.agendafacil.dto.response.ServiceResponse

typealias ServiceListener = (ServiceResponse) -> Unit

class ServiceListFragmentAdapter(private val listener: ServiceListener): ListAdapter<ServiceResponse, ServiceListFragmentAdapter.ServiceViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        return ServiceViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    class ServiceViewHolder(private val itemLayoutBind: ServiceItemLayoutBinding): RecyclerView.ViewHolder(itemLayoutBind.root){

        fun bind(service: ServiceResponse, listener: ServiceListener){
            itemLayoutBind.service = service

            itemLayoutBind.root.setOnClickListener {
                listener.invoke(service)
            }
        }

        companion object {
            fun create(parent: ViewGroup): ServiceViewHolder{
                val itemBind = ServiceItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ServiceViewHolder(itemBind)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ServiceResponse>(){

            override fun areItemsTheSame(oldItem: ServiceResponse, newItem: ServiceResponse): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ServiceResponse, newItem: ServiceResponse): Boolean {
                return oldItem.address == newItem.address
            }

        }
    }
}