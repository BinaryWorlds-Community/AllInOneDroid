package com.example.allinone.data.repositories

import androidx.lifecycle.viewModelScope
import com.example.allinone.data.AppDatabase
import com.example.allinone.data.dao.StorageItemDao
import com.example.allinone.data.entities.StorageItem
import kotlinx.coroutines.launch

class RoomStorageItemRepository(private val database: AppDatabase) : IRepository<StorageItem> {
    private var items = mutableListOf<StorageItem>()

    override suspend fun getAll(): Iterable<StorageItem> {
        items = database.storageItemDao().getAllStorageItems()
        return items
    }

    override fun getOne(): StorageItem {
        TODO("Not yet implemented")
    }

    override fun getByID(id: Int): StorageItem? {
        TODO("Not yet implemented")
    }

    override fun getByName(name: String): StorageItem? {
        TODO("Not yet implemented")
    }

    override fun deleteByID(id: Int) {
        TODO("Not yet implemented")
    }

    override fun createMultiple(entities: Iterable<StorageItem>) {
        TODO("Not yet implemented")
    }

    override suspend fun createOne(entity: StorageItem) {
        database.storageItemDao().insertStorageItem(entity)
    }

    override fun updateMultiple(entities: Iterable<StorageItem>) {
        TODO("Not yet implemented")
    }

    override fun updateOne(entity: StorageItem) {
        TODO("Not yet implemented")
    }

    override suspend fun getStorageSuggestions(query: String) : List<StorageItem> {
        return database.storageItemDao().getStorageItemNames(query)
    }
}