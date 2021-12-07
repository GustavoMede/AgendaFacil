package com.example.agendafacil.ui.fragments.scheduleslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.agendafacil.databinding.ScheduleItemLayoutBinding
import com.example.agendafacil.databinding.ScheduleItemLayoutBindingImpl
import com.example.agendafacil.databinding.ScheduleListFragmentLayoutBinding
import com.example.agendafacil.databinding.ServiceItemLayoutBinding
import com.example.agendafacil.dto.response.ScheduleResponse
import com.example.agendafacil.dto.response.ServiceResponse

class ScheduleListFragmentAdapter: ListAdapter<ScheduleResponse, ScheduleListFragmentAdapter.ScheduleViewHolder>(DIFF_CALLBACK)  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        return ScheduleViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ScheduleViewHolder(private val itemLayoutBind: ScheduleItemLayoutBinding): RecyclerView.ViewHolder(itemLayoutBind.root){

        fun bind(schedule: ScheduleResponse){
            itemLayoutBind.schedule = schedule
        }

        companion object {
            fun create(parent: ViewGroup): ScheduleViewHolder{
                val itemBind = ScheduleItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ScheduleViewHolder(itemBind)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ScheduleResponse>(){

            override fun areItemsTheSame(oldItem: ScheduleResponse, newItem: ScheduleResponse): Boolean {
                return oldItem.servico.id == newItem.servico.id
            }

            override fun areContentsTheSame(oldItem: ScheduleResponse, newItem: ScheduleResponse): Boolean {
                return oldItem.servico == newItem.servico
            }

        }
    }
}