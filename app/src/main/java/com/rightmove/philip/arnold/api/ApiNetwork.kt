package com.rightmove.philip.arnold.api

import com.rightmove.philip.arnold.model.Properties
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiNetwork {
    @GET("properties.json")
    fun getProperties(): Deferred<Properties>
}