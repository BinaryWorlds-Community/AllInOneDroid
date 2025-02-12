package com.example.allinone.data.repositories

import com.example.allinone.data.entities.StorageItem

class MockStorageItemRepository : IRepository<StorageItem> {

    private var items = mutableListOf<StorageItem>(
        StorageItem(1, "tomato", 1f), //, 1, 1.5f),
        StorageItem(2, "cucumber", 1f), //, 2, 1.5f),
        StorageItem(3, "carrot",2f), //, 1, 2.5f)
    )
    override suspend fun getAll(): Iterable<StorageItem> {
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
        TODO("Not yet implemented")
    }

    override fun updateMultiple(entities: Iterable<StorageItem>) {
        TODO("Not yet implemented")
    }

    override fun updateOne(entity: StorageItem) {
        TODO("Not yet implemented")
    }
}