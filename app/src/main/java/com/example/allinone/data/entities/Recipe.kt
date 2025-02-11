package com.example.allinone.data.entities

import android.graphics.Bitmap
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val title : String,
    val titleImage : String,
    val portionFactor : Int
)
