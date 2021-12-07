package com.example.agendafacil.ui.fragments.serviceadd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agendafacil.databinding.InputItemLayoutBinding
import com.example.agendafacil.dto.request.InputRequest

class ServiceInputsAdapter(
    private val inputs: List<InputRequest>
): RecyclerView.Adapter<ServiceInputsAdapter.ServiceInputsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceInputsViewHolder {
        val view = InputItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ServiceInputsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceInputsViewHolder, position: Int) {
        val input = inputs[position]
        holder.bind(input)
    }

    class ServiceInputsViewHolder(private val itemLayoutBind: InputItemLayoutBinding): RecyclerView.ViewHolder(itemLayoutBind.root){

        fun bind(input: InputRequest){
            itemLayoutBind.input = input
        }
    }

    override fun getItemCount(): Int = inputs.size
}