package com.example.allinone.data.repositories

import com.example.allinone.data.entities.ShoppingItem

class MockShoppingItemRepository : IRepository<ShoppingItem> {

    private var items = mutableListOf<ShoppingItem>(
        ShoppingItem(1,1,1.0f,false),
        ShoppingItem(2,2,2.0f,false),
        ShoppingItem(3,3,3.0f,false)
    )
    override suspend fun getAll(): Iterable<ShoppingItem> {
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
        TODO("Not yet implemented")
    }

    override fun updateMultiple(entities: Iterable<ShoppingItem>) {
        TODO("Not yet implemented")
    }

    override fun updateOne(entity: ShoppingItem) {
        TODO("Not yet implemented")
    }
}