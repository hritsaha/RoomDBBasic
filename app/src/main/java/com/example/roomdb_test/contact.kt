package com.example.roomdb_test

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "contact")
data class contact(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var name : String,
    var phone : Long,
    var createDate : Date,
    var isActive : Int
)
