package com.example.allinone.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "storageItems")
data class StorageItem(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val ingredientName : String,
    //val ingredientId: Int,
    //val locationId: Int,
    val amount: Float
)
