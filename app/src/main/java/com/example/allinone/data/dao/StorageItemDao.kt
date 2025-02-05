package com.example.allinone.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.allinone.data.entities.StorageItem

@Dao
interface StorageItemDao{
    @Query("SELECT * FROM storageItems")
    suspend fun getAllStorageItems(): MutableList<StorageItem>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStorageItem(storageItem: StorageItem)
    @Update
    suspend fun updateStorageItem(storageItem: StorageItem)
    @Delete
    suspend fun deleteStorageItem(storageItem: StorageItem)
}