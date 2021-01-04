package com.rightmove.philip.arnold.repo

import com.rightmove.philip.arnold.api.UseCaseResult
import com.rightmove.philip.arnold.model.Properties
import com.rightmove.philip.arnold.model.Property

class PropertiesRepositoryImpTripleMock: PropertiesRepository {
    override suspend fun getProperties(): UseCaseResult<Properties> {
        val property1 = Property(
            id = 1,
            price = 750000,
            bedrooms = 5,
            bathrooms = 2,
            number = "12",
            address = "Richard Lane",
            region = "London",
            postcode = "W1F 3FT",
            propertyType = "DETACHED"
        )
        val property2 = Property(
            id = 1,
            price = 500000,
            bedrooms = 4,
            bathrooms = 2,
            number = "13",
            address = "John Street",
            region = "London",
            postcode = "AB1 4AB",
            propertyType = "SEMI-DETACHED"
        )
        val property3 = Property(
            id = 1,
            price = 250000,
            bedrooms = 3,
            bathrooms = 1,
            number = "13",
            address = "Joseph Road",
            region = "London",
            postcode = "CD2 5CD",
            propertyType = "APPARTMENT"
        )
        val result = Properties(listOf(property1, property2, property3))
        return UseCaseResult.Success(result)
    }
}