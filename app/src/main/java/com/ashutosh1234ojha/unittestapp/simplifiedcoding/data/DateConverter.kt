package com.ashutosh1234ojha.unittestapp.simplifiedcoding.data

import androidx.room.TypeConverter
import java.util.*

/**
 * Created by Ashutosh Ojha on 17,December,2021
 */
class DateConverter {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}