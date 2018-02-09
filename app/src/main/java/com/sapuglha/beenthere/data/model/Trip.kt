package com.sapuglha.beenthere.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "trip")
class Trip {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    var title: String = ""
    var description: String? = ""

    var startDate: Date = Calendar.getInstance().time
    var endDate: Date? = null

    fun hasDescription(): Boolean {
        return description?.isEmpty() ?: false
    }
}