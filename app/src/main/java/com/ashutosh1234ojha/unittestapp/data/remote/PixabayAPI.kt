package com.ashutosh1234ojha.unittestapp.data.remote

import com.ashutosh1234ojha.unittestapp.BuildConfig
import com.ashutosh1234ojha.unittestapp.data.remote.responses.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Ashutosh Ojha on 29,October,2021
 */
interface PixabayAPI {
    @GET("/api/")
    suspend fun searchForImage(
        @Query("q") searchQuery: String,
        @Query("key") apiKey: String = BuildConfig.API_KEY
    ): Response<ImageResponse>
}