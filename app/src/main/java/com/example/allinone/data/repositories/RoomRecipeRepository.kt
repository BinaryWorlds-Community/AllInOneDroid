package com.example.allinone.data.repositories

import com.example.allinone.data.AppDatabase
import com.example.allinone.data.entities.Recipe
import com.example.allinone.data.entities.RecipeWithSteps
import com.example.allinone.data.entities.StorageItem

class RoomRecipeRepository(private val database: AppDatabase) : IRepository<RecipeWithSteps> {
    private var items = mutableListOf<RecipeWithSteps>()

    override suspend fun getAll(): Iterable<RecipeWithSteps> {
        items = database.recipeDao().getAllRecipes()
        return items
    }

    override fun getOne(): RecipeWithSteps {
        TODO("Not yet implemented")
    }

    override fun getByID(id: Int): RecipeWithSteps? {
        TODO("Not yet implemented")
    }

    override fun getByName(name: String): RecipeWithSteps? {
        TODO("Not yet implemented")
    }

    override fun deleteByID(id: Int) {
        TODO("Not yet implemented")
    }

    override fun createMultiple(entities: Iterable<RecipeWithSteps>) {
        TODO("Not yet implemented")
    }

    override suspend fun createOne(entity: RecipeWithSteps) {
        TODO("Not yet implemented")
    }

    override fun updateMultiple(entities: Iterable<RecipeWithSteps>) {
        TODO("Not yet implemented")
    }

    override fun updateOne(entity: RecipeWithSteps) {
        TODO("Not yet implemented")
    }
}