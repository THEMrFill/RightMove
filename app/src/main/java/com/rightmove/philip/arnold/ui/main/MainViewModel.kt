package com.rightmove.philip.arnold.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rightmove.philip.arnold.api.SingleLiveEvent
import com.rightmove.philip.arnold.api.UseCaseResult
import com.rightmove.philip.arnold.model.Properties
import com.rightmove.philip.arnold.repo.PropertiesRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel(val propertiesRepository: PropertiesRepository) : ViewModel(), CoroutineScope {
    // Coroutine's background job
    private val job = Job()

    // Define default thread for Coroutine as Main and add job
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    val showLoading = MutableLiveData(true)
    val showError = SingleLiveEvent<String>()
    val listOfProperties = MutableLiveData<Properties>()

    init {
        loadProperties()
    }

    private fun loadProperties() {
        showLoading.value = true

        launch {
            when (val result = withContext(Dispatchers.IO) { propertiesRepository.getProperties() }) {
                is UseCaseResult.Success -> {
                    showLoading.value = false
                    listOfProperties.value = result.data
                }
                is UseCaseResult.Error -> {
                    showLoading.value = false
                    showError.value = result.exception.message
                }
            }
        }
    }
}