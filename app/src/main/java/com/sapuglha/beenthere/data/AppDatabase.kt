package com.sapuglha.beenthere.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.sapuglha.beenthere.data.converter.DateConverter
import com.sapuglha.beenthere.data.dao.TripDao
import com.sapuglha.beenthere.data.model.Trip

@Database(
        entities = [
            (Trip::class)
        ],
        version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tripDao(): TripDao

    companion object {
        private var instance: AppDatabase? = null
        @Synchronized
        fun get(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room
                        .databaseBuilder(context.applicationContext, AppDatabase::class.java, "tripDatabase")
                        .build()
            }
            return instance!!
        }
    }
}
