package com.ashutosh1234ojha.unittestapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Ashutosh Ojha on 24,October,2021
 */
@Entity(tableName = "shopping_items")
data class ShoppingItem(
    var name: String,
    var amount: Int,
    var price: Float,
    var imageUrl: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)