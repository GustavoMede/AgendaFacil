package com.example.agendafacil.di

import com.example.agendafacil.repository.clientrepository.ClientRepository
import com.example.agendafacil.repository.clientrepository.ClientRepositoryImpl
import com.example.agendafacil.repository.datasource.clientdatasource.ClientDataSource
import com.example.agendafacil.repository.datasource.clientdatasource.ClientDataSourceImpl
import com.example.agendafacil.repository.datasource.professionaldatasource.ProfessionalDataSource
import com.example.agendafacil.repository.datasource.professionaldatasource.ProfessionalDataSourceImpl
import com.example.agendafacil.repository.professionalrepository.ProfessionalRepository
import com.example.agendafacil.repository.professionalrepository.ProfessionalRepositoryImpl
import com.example.agendafacil.ui.fragments.clientsignup.ClientSignUpViewModel
import com.example.agendafacil.ui.fragments.professionalsignup.ProfessionalSignUpViewModel
import com.example.agendafacil.usecase.onclientsignup.OnClientSignUpUseCase
import com.example.agendafacil.usecase.onclientsignup.OnClientSignUpUseCaseImpl
import com.example.agendafacil.usecase.onprofessionalsignup.OnProfessionalSignUpUseCase
import com.example.agendafacil.usecase.onprofessionalsignup.OnProfessionalSignUpUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {

    single<ClientRepository>{
        ClientRepositoryImpl(get())
    }

    single<ProfessionalRepository>{
        ProfessionalRepositoryImpl(get())
    }

    factory<ClientDataSource> {
        ClientDataSourceImpl()
    }

    factory<ProfessionalDataSource> {
        ProfessionalDataSourceImpl()
    }

    factory<OnClientSignUpUseCase> {
        OnClientSignUpUseCaseImpl(get())
    }
    factory<OnProfessionalSignUpUseCase> {
        OnProfessionalSignUpUseCaseImpl(get())
    }

    viewModel { ClientSignUpViewModel(get()) }
    viewModel { ProfessionalSignUpViewModel(get()) }
}