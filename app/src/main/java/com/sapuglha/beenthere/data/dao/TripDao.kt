package com.sapuglha.beenthere.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.sapuglha.beenthere.data.model.Trip

@Dao
interface TripDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertTrip(trip: Trip)

    @Query("select * from trip where id = :id")
    fun tripById(id: Long): Trip

}