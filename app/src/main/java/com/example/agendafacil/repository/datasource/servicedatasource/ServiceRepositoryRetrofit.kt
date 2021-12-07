package com.example.agendafacil.repository.datasource.servicedatasource

import com.example.agendafacil.common.URL_BASE
import com.example.agendafacil.repository.datasource.professionaldatasource.ProfessionalApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ServiceRepositoryRetrofit {

    fun getData(): ServiceApiService {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(URL_BASE)
            .build()
            .create(ServiceApiService::class.java)
    }
}