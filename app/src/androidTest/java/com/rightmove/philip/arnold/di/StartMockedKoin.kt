package com.rightmove.philip.arnold.di

import org.koin.core.context.startKoin

object StartMockedKoin {
    fun startMockedKoin(count: Int = 1) {
        startKoin {
            when (count) {
                1 ->
                    modules(appModulesSingleMock)
                3 ->
                    modules(appModulesTripleMock)
            }
        }
    }
}