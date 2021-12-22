package com.ashutosh1234ojha.unittestapp.simplifiedcoding.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Created by Ashutosh Ojha on 17,December,2021
 */
@Dao
interface SpendDao {

    @Insert
    suspend fun addSpend(spend: Spend)

    @Query("SELECT * FROM spends ORDER BY date DESC LIMIT 20")
    suspend fun getLast20Spends(): List<Spend>

}