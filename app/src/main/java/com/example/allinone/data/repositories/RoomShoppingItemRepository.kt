package com.example.allinone.data.repositories

import com.example.allinone.data.AppDatabase
import com.example.allinone.data.entities.ShoppingItem

class RoomShoppingItemRepository(private val database: AppDatabase) : IRepository<ShoppingItem> {
    private var items = mutableListOf<ShoppingItem>()

    override suspend fun getAll(): Iterable<ShoppingItem> {
        items = database.shoppingItemDao().getAllShoppingItems()
        return items
    }

    override fun getOne(): ShoppingItem {
        TODO("Not yet implemented")
    }

    override fun getByID(id: Int): ShoppingItem? {
        TODO("Not yet implemented")
    }

    override fun getByName(name: String): ShoppingItem? {
        TODO("Not yet implemented")
    }

    override fun deleteByID(id: Int) {
        TODO("Not yet implemented")
    }

    override fun createMultiple(entities: Iterable<ShoppingItem>) {
        TODO("Not yet implemented")
    }

    override suspend fun createOne(entity: ShoppingItem) {
        database.shoppingItemDao().insertShoppingItem(entity)
    }

    override fun updateMultiple(entities: Iterable<ShoppingItem>) {
        TODO("Not yet implemented")
    }

    override fun updateOne(entity: ShoppingItem) {
        TODO("Not yet implemented")
    }
}