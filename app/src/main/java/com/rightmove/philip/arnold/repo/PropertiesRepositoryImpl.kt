package com.rightmove.philip.arnold.repo

import com.rightmove.philip.arnold.api.ApiNetwork
import com.rightmove.philip.arnold.api.UseCaseResult
import com.rightmove.philip.arnold.model.Properties

class PropertiesRepositoryImpl(val api: ApiNetwork): PropertiesRepository {
    override suspend fun getProperties(): UseCaseResult<Properties> {
        return try {
            val result = api.getProperties().await()
            UseCaseResult.Success(result)
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }
}