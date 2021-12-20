package com.example.roomdb_test

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [contact :: class],version = 2)
@TypeConverters(convertors :: class)

abstract class contactDatabase  : RoomDatabase(){

    abstract fun contactDAO() : contactDAO

    companion object{

        val migration_1_2 = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }

        }

        //Volatile updates all the threads about the creation of the object
        @Volatile
        private var instance :contactDatabase? = null

        public fun getDatabase(context : Context) : contactDatabase{
            if(instance == null){
                /*many times different threads can try to create the database instance but we do not want that
                * so we use synchronized block to avoid this problem*/
                    synchronized(this){
                        instance = Room.databaseBuilder(context.applicationContext,contactDatabase  :: class.java,"contactDB").addMigrations(migration_1_2).build()
                    }
            }
            return instance!!
        }

    }

}