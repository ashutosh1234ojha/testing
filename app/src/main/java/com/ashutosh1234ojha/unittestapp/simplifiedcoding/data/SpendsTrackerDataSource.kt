package com.ashutosh1234ojha.unittestapp.simplifiedcoding.data

/**
 * Created by Ashutosh Ojha on 17,December,2021
 */
class SpendsTrackerDataSource(
    private val db: SpendDao
) {
    suspend fun addSpend(spend: Spend) = db.addSpend(spend)

    suspend fun getLast20Spends() = db.getLast20Spends()
}