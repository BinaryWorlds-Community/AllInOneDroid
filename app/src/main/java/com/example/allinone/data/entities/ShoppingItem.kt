package com.example.allinone.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shoppingItems")
data class ShoppingItem(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val ingredientId: Int,
    val amount: Float,
    val isBought: Boolean
)
