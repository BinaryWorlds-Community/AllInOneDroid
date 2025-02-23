package com.example.allinone.data.repositories

import com.example.allinone.data.Ingredient
import kotlin.random.Random

class MockIngredientRepository : IRepository<Ingredient> {

    private var ingredients = mutableListOf(
        Ingredient(1,"Tomate"),
        Ingredient(2, "Gurke"),
        Ingredient(3, "Nudeln")
    )

    override suspend fun getAll(): Iterable<Ingredient> {
        return ingredients
    }

    override fun getOne(): Ingredient {
        return ingredients[Random.nextInt(0, ingredients.count())]
    }

    override fun getByID(id: Int): Ingredient? {
        return ingredients.find { i -> i.id == id }
    }

    override fun getByName(name: String): Ingredient? {
        TODO("Not yet implemented")
    }

    override fun deleteByID(id: Int) {
        TODO("Not yet implemented")
    }

    override fun createMultiple(entities: Iterable<Ingredient>) {
        TODO("Not yet implemented")
    }

    override suspend fun createOne(entity: Ingredient) {
        ingredients.add(entity)
    }

    override fun updateMultiple(entities: Iterable<Ingredient>) {
        ingredients = entities.toMutableList()
    }

    override fun updateOne(entity: Ingredient) = try {
        val oldEntity = ingredients.filter { i -> i.id == entity.id }
        ingredients[ingredients.indexOf(oldEntity[0])] = entity
    }
    catch (ex : Exception){

    }

    override suspend fun getStorageSuggestions(query:String) : List<Ingredient> {
        TODO("Not yet implemented")
    }
}