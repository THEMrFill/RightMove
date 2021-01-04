package com.rightmove.philip.arnold.repo

import com.rightmove.philip.arnold.api.UseCaseResult
import com.rightmove.philip.arnold.model.Properties
import com.rightmove.philip.arnold.model.Property

class PropertiesRepositoryImpSingleMock: PropertiesRepository {
    override suspend fun getProperties(): UseCaseResult<Properties> {
        val property = Property(
                id = 1,
                price = 1000000,
                bedrooms = 7,
                bathrooms = 2,
                number = "12",
                address = "Richard Lane",
                region = "London",
                postcode = "W1F 3FT",
                propertyType = "DETACHED"
        )
        val result = Properties(listOf(property))
        return UseCaseResult.Success(result)
    }
}