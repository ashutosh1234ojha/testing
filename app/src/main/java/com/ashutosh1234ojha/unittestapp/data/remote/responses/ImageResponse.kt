package com.ashutosh1234ojha.unittestapp.data.remote.responses

/**
 * Created by Ashutosh Ojha on 29,October,2021
 */
data class ImageResponse(
    val hits: List<ImageResult>,
    val total: Int,
    val totalHits: Int
)