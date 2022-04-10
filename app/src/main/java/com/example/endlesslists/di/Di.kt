package com.example.endlesslists.di

import com.example.endlesslists.data.repository.RepositoryImpl
import com.example.endlesslists.data.repository.datasource.CloudSource
import com.example.endlesslists.data.repository.datasource.CloudSourceImpl
import com.example.endlesslists.data.repository.datasource.api.BackendRepo
import com.example.endlesslists.domain.repository.Repository
import com.example.endlesslists.presenter.main.MainFragment
import com.example.endlesslists.presenter.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Di {
    fun sourceModules() = module {
        single<CloudSource> {
            CloudSourceImpl(BackendRepo.api)
        }
    }

    fun repositoryModule() = module {
        single<Repository> {
            RepositoryImpl(get(), BackendRepo.api)
        }
    }

    fun viewModules() = module {
        scope<MainFragment> {
            viewModel { MainViewModel(get()) }
        }
    }
}