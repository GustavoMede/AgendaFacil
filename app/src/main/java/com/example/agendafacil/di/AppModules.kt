package com.example.agendafacil.di

import com.example.agendafacil.repository.clientepository.ClientRepository
import com.example.agendafacil.repository.clientepository.ClientRepositoryImpl
import com.example.agendafacil.repository.datasource.clientdatasource.ClientDataSource
import com.example.agendafacil.repository.datasource.clientdatasource.ClientDataSourceImpl
import com.example.agendafacil.repository.datasource.inputadddatasource.InputAddLocalDataSource
import com.example.agendafacil.repository.datasource.inputadddatasource.InputAddLocalDataSourceImpl
import com.example.agendafacil.repository.datasource.logindatasource.LoginDataSource
import com.example.agendafacil.repository.datasource.logindatasource.LoginDataSourceImpl
import com.example.agendafacil.repository.datasource.professionaldatasource.ProfessionalDataSource
import com.example.agendafacil.repository.datasource.professionaldatasource.ProfessionalDataSourceImpl
import com.example.agendafacil.repository.datasource.scheduledatasource.ScheduleDataSource
import com.example.agendafacil.repository.datasource.scheduledatasource.ScheduleDataSourceImpl
import com.example.agendafacil.repository.datasource.servicedatasource.ServiceDataSource
import com.example.agendafacil.repository.datasource.servicedatasource.ServiceDataSourceImpl
import com.example.agendafacil.repository.inputrepository.InputRepository
import com.example.agendafacil.repository.inputrepository.InputRepositoryImpl
import com.example.agendafacil.repository.loginrepository.LoginRepository
import com.example.agendafacil.repository.loginrepository.LoginRepositoryImpl
import com.example.agendafacil.repository.professionalrepository.ProfessionalRepository
import com.example.agendafacil.repository.professionalrepository.ProfessionalRepositoryImpl
import com.example.agendafacil.repository.schedulerepository.ScheduleRepository
import com.example.agendafacil.repository.schedulerepository.ScheduleRepositoryImpl
import com.example.agendafacil.repository.servicerepository.ServiceRepository
import com.example.agendafacil.repository.servicerepository.ServiceRepositoryImpl
import com.example.agendafacil.ui.fragments.clientsignup.ClientSignUpViewModel
import com.example.agendafacil.ui.fragments.inputsadd.ServiceInputsAddViewModel
import com.example.agendafacil.ui.fragments.login.LoginFragmentViewModel
import com.example.agendafacil.ui.fragments.professionalsignup.ProfessionalSignUpViewModel
import com.example.agendafacil.ui.fragments.scheduleservice.ScheduleServiceViewModel
import com.example.agendafacil.ui.fragments.scheduleslist.ScheduleListViewModel
import com.example.agendafacil.ui.fragments.serviceadd.ServiceAddViewModel
import com.example.agendafacil.ui.fragments.servicesList.ServiceListViewModel
import com.example.agendafacil.usecase.getinputsusecase.OnGetInputsUseCase
import com.example.agendafacil.usecase.getinputsusecase.OnGetInputsUseCaseImpl
import com.example.agendafacil.usecase.getschedules.OnGetSchedulesUseCase
import com.example.agendafacil.usecase.getschedules.OnGetSchedulesUseCaseImpl
import com.example.agendafacil.usecase.inputaddusecase.OnInputAddUseCase
import com.example.agendafacil.usecase.inputaddusecase.OnInputAddUseCaseImpl
import com.example.agendafacil.usecase.onclearinputlistusecase.OnClearInputListUseCase
import com.example.agendafacil.usecase.onclearinputlistusecase.OnClearInputListUseCaseImpl
import com.example.agendafacil.usecase.onclientsignup.OnClientSignUpUseCase
import com.example.agendafacil.usecase.onclientsignup.OnClientSignUpUseCaseImpl
import com.example.agendafacil.usecase.onlogin.OnLoginUseCase
import com.example.agendafacil.usecase.onlogin.OnLoginUseCaseImpl
import com.example.agendafacil.usecase.onprofessionalsignup.OnProfessionalSignUpUseCase
import com.example.agendafacil.usecase.onprofessionalsignup.OnProfessionalSignUpUseCaseImpl
import com.example.agendafacil.usecase.onscheduleserviceusecase.OnScheduleServiceUseCase
import com.example.agendafacil.usecase.onscheduleserviceusecase.OnScheduleServiceUseCaseImpl
import com.example.agendafacil.usecase.onserviceaddusecase.OnServiceAddUseCase
import com.example.agendafacil.usecase.onserviceaddusecase.OnServiceAddUseCaseImpl
import com.example.agendafacil.usecase.servicelistusecase.ServiceListUseCase
import com.example.agendafacil.usecase.servicelistusecase.ServiceListUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {

    single<ClientRepository>{
        ClientRepositoryImpl(get())
    }

    single<ProfessionalRepository>{
        ProfessionalRepositoryImpl(get())
    }

    single<ServiceRepository> {
        ServiceRepositoryImpl(get())
    }

    single<LoginRepository> {
        LoginRepositoryImpl(get())
    }

    single<InputRepository> {
        InputRepositoryImpl(get())
    }

    single<ScheduleRepository> {
        ScheduleRepositoryImpl(get())
    }

    single<OnServiceAddUseCase> {
        OnServiceAddUseCaseImpl(get())
    }

    factory<ClientDataSource> {
        ClientDataSourceImpl()
    }

    factory<ProfessionalDataSource> {
        ProfessionalDataSourceImpl()
    }

    factory<LoginDataSource> {
        LoginDataSourceImpl()
    }

    factory<ServiceDataSource> {
        ServiceDataSourceImpl()
    }

    factory<InputAddLocalDataSource> {
        InputAddLocalDataSourceImpl()
    }

    factory<ScheduleDataSource> {
        ScheduleDataSourceImpl()
    }

    factory<OnClientSignUpUseCase> {
        OnClientSignUpUseCaseImpl(get())
    }

    factory<OnProfessionalSignUpUseCase> {
        OnProfessionalSignUpUseCaseImpl(get())
    }

    factory<OnLoginUseCase> {
        OnLoginUseCaseImpl(get())
    }

    factory<ServiceListUseCase> {
        ServiceListUseCaseImpl(get())
    }

    factory<OnInputAddUseCase> {
        OnInputAddUseCaseImpl(get())
    }

    factory<OnGetInputsUseCase> {
        OnGetInputsUseCaseImpl(get())
    }

    factory<OnClearInputListUseCase> {
        OnClearInputListUseCaseImpl(get())
    }

    factory<OnScheduleServiceUseCase> {
        OnScheduleServiceUseCaseImpl(get())
    }

    factory<OnGetSchedulesUseCase> {
        OnGetSchedulesUseCaseImpl(get())
    }

    viewModel { ClientSignUpViewModel(get()) }
    viewModel { ProfessionalSignUpViewModel(get()) }
    viewModel { LoginFragmentViewModel(get()) }
    viewModel { ServiceListViewModel(get()) }
    viewModel { ServiceInputsAddViewModel(get()) }
    viewModel { ServiceAddViewModel(get(), get(), get()) }
    viewModel { ScheduleServiceViewModel(get()) }
    viewModel { ScheduleListViewModel(get()) }
}