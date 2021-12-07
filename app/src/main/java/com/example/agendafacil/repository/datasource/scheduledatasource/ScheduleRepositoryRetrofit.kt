package com.example.agendafacil.repository.datasource.scheduledatasource

import com.example.agendafacil.common.URL_BASE
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ScheduleRepositoryRetrofit {
    fun sendRequest(): ScheduleApiService {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(URL_BASE)
            .build()
            .create(ScheduleApiService::class.java)
    }

}