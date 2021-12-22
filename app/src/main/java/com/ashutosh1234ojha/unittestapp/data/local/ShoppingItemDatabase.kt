package com.ashutosh1234ojha.unittestapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by Ashutosh Ojha on 24,October,2021
 */
@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingItemDatabase:RoomDatabase() {
    abstract fun shoppingDao(): ShoppingDao

}