package com.example.allinone.data.entities

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_steps")
data class RecipeStep(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val orderNo: Int,
    val recipeId : Int,
    val description : String,
    val image : String,
)
