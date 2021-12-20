package com.example.roomdb_test

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface contactDAO {

    @Insert
    suspend fun insertContact(contact :contact)

    @Update
    suspend fun updateContact(contact :contact)

    @Delete
    suspend fun deleteContact(contact :contact)

    @Query("SELECT * FROM contact")
    fun getContact() : LiveData<List<contact>>
}