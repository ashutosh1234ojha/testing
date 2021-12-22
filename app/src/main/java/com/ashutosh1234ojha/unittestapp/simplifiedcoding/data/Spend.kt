package com.ashutosh1234ojha.unittestapp.simplifiedcoding.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * Created by Ashutosh Ojha on 17,December,2021
 */
@Entity(tableName = "spends")
data class Spend(
    val date: Date,
    val amount: Int,
    val description: String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}