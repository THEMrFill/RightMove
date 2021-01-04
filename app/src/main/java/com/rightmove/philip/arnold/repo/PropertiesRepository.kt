package com.rightmove.philip.arnold.repo

import com.rightmove.philip.arnold.api.UseCaseResult
import com.rightmove.philip.arnold.model.Properties

interface PropertiesRepository {
    suspend fun getProperties(): UseCaseResult<Properties>
}