package com.rightmove.philip.arnold.di

import com.rightmove.philip.arnold.repo.PropertiesRepository
import com.rightmove.philip.arnold.repo.PropertiesRepositoryImpSingleMock
import com.rightmove.philip.arnold.repo.PropertiesRepositoryImpTripleMock
import com.rightmove.philip.arnold.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModulesSingleMock = module {
    // factories for Koin
    single<PropertiesRepository> { PropertiesRepositoryImpSingleMock() }

    // viewModel for Koin
    viewModel { MainViewModel(get()) }
}

val appModulesTripleMock = module {
    // factories for Koin
    single<PropertiesRepository> { PropertiesRepositoryImpTripleMock() }

    // viewModel for Koin
    viewModel { MainViewModel(get()) }
}
