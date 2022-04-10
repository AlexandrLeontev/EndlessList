package com.example.endlesslists.data.repository.datasource.api

import com.example.endlesslists.domain.models.Data
import retrofit2.http.GET
import retrofit2.http.Query

interface BackendApi {
    @GET("top.json")
    suspend fun getPosts(): Data
    @GET("top.json")
    suspend fun getMorePosts(@Query("after") after: String): Data
}