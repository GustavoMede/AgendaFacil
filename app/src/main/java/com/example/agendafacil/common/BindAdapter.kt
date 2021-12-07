package com.example.agendafacil.common

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("serviceName")
fun serviceName(textView: TextView, serviceName: String?){
    serviceName?.let {
        textView.text = serviceName
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("serviceValue")
fun serviceValue(textView: TextView, serviceValue: Double?){
    serviceValue?.let {
        textView.text = "R$$serviceValue"
    }
}

@BindingAdapter("professionalName")
fun professionalName(textView: TextView, professionalName: String?){
    professionalName?.let {
        textView.text = professionalName
    }
}

@BindingAdapter("professionalEmail")
fun professionalEmail(textView: TextView, professionalEmail: String?){
    professionalEmail?.let {
        textView.text = professionalEmail
    }
}

@BindingAdapter("local")
fun local(textView: TextView, local: String?){
    local?.let {
        textView.text = local
    }
}

@BindingAdapter("jobType")
fun jobType(textView: TextView, jobType: String?){
    jobType?.let {
        if (jobType == "TEMPOINTEGRAL"){
            textView.text = "TEMPO INTEGRAL"
        } else if (jobType == "MEIOPERIODO"){
            textView.text = "MEIO PERIODO"
        } else textView.text = jobType
    }
}

@BindingAdapter("inputName")
fun inputName(textView: TextView, inputName: String?){
    inputName?.let {
        textView.text = "Nome: " + inputName
    }
}

@BindingAdapter("inputDescription")
fun inputDescription(textView: TextView, inputDescription: String?){
    inputDescription?.let {
        textView.text = "Descrição: " + inputDescription
    }
}

@BindingAdapter("scheduleHour")
fun scheduleHour(textView: TextView, scheduleHour: Int?){
    scheduleHour?.let {
        textView.text = "Horário: " + scheduleHour.toString()
    }
}