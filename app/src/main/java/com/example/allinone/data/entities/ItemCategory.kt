package com.example.allinone.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itemCategories")
data class ItemCategory(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val name : String,
)