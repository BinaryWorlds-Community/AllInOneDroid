package com.example.allinone.data.repositories

import com.example.allinone.data.Recipe
import com.example.allinone.data.r001steps

class MockRecipeRepository  : IRepository<Recipe> {

    private val mockIngredientRepository = MockIngredientRepository()
    override suspend fun getAll(): Iterable<Recipe> {
        TODO("Not yet implemented")
    }

    override fun getOne(): Recipe {
        val ingredient = mockIngredientRepository.getOne()
        var recipe = Recipe(
            1,
            "Tomate Gurken Salat",
            mapOf(ingredient to 2),
            r001steps
        )
        return recipe
    }

    override fun getByID(id: Int): Recipe? {
        TODO("Not yet implemented")
    }

    override fun getByName(name: String): Recipe? {
        TODO("Not yet implemented")
    }

    override fun deleteByID(id: Int) {
        TODO("Not yet implemented")
    }

    override fun createMultiple(entities: Iterable<Recipe>) {
        TODO("Not yet implemented")
    }

    override suspend fun createOne(entity: Recipe) {
        TODO("Not yet implemented")
    }

    override fun updateMultiple(entities: Iterable<Recipe>) {
        TODO("Not yet implemented")
    }

    override fun updateOne(entity: Recipe) {
        TODO("Not yet implemented")
    }
}