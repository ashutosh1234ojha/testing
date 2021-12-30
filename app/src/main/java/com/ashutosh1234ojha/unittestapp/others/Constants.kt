package com.ashutosh1234ojha.unittestapp.others

import androidx.annotation.VisibleForTesting

/**
 * Created by Ashutosh Ojha on 29,October,2021
 */

object Constants {

    const val DATABASE_NAME = "shopping_db"

    const val BASE_URL = "https://pixabay.com"
    const val MAX_NAME_LENGTH = 20
    const val MAX_PRICE_LENGTH = 20

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
     fun my(){}
}