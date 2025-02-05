package com.example.allinone.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.allinone.data.entities.ShoppingItem

@Dao
interface ShoppingItemDao{
    @Query("SELECT * FROM shoppingItems")
    suspend fun getAllShoppingItems(): MutableList<ShoppingItem>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)
    @Update
    suspend fun updateShoppingItem(shoppingItem: ShoppingItem)
    @Delete
    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)
}