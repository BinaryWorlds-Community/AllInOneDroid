package com.example.allinone.data.repositories

import com.example.allinone.data.Ingredient
import com.example.allinone.data.UserAccount

class MockUserAccountRepository : IRepository<UserAccount>{
    override suspend fun getAll(): Iterable<UserAccount> {
        return listOf(UserAccount(id = 1L, firstName = "Test", email = "test@mail.com"),
            UserAccount(id = 2L, firstName = "Bob", email = "bob@mail.com"),
            UserAccount(id = 2L, firstName = "Mary", email = "mary@mail.com")
        )
    }

    override fun getOne(): UserAccount {
        return UserAccount(id = 1L, firstName = "Test", email = "test@mail.com")
    }

    override fun getByID(id: Int): UserAccount? {
        TODO("Not yet implemented")
    }

    override fun getByName(name: String): UserAccount? {
        TODO("Not yet implemented")
    }

    override fun deleteByID(id: Int) {
        TODO("Not yet implemented")
    }

    override fun createMultiple(entities: Iterable<UserAccount>) {
        TODO("Not yet implemented")
    }

    override suspend fun createOne(entity: UserAccount) {
        TODO("Not yet implemented")
    }

    override fun updateMultiple(entities: Iterable<UserAccount>) {
        TODO("Not yet implemented")
    }

    override fun updateOne(entity: UserAccount) {
        TODO("Not yet implemented")
    }
    override suspend fun getStorageSuggestions(query:String) : List<UserAccount> {
        TODO("Not yet implemented")
    }
}