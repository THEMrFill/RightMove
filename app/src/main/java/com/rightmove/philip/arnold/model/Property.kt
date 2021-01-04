package com.rightmove.philip.arnold.model

data class Property(
    val address: String,
    val bathrooms: Int,
    val bedrooms: Int,
    val id: Int,
    val number: String,
    val postcode: String,
    val price: Int,
    val propertyType: String,
    val region: String
)