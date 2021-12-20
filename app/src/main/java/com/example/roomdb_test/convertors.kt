package com.example.roomdb_test

import androidx.room.TypeConverter
import java.util.*

class convertors {
    @TypeConverter
    fun fromDateToLong(value : Date) : Long{
        return value.time
    }

    @TypeConverter
    fun fromLongToDate(value: Long) : Date{
        return Date(value)
    }
}