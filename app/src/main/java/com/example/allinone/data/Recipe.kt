package com.example.allinone.data

import android.icu.text.CaseMap.Title
import com.example.allinone.data.repositories.MockIngredientRepository
import java.util.Dictionary

data class Recipe(
    val id : Long,
    val title: String,
    val ingredients: Map<Ingredient, Int>,
    val steps: Iterable<RecipeStep>
)

/** ToDo: clean up **/
private val mockIngredientRepository = MockIngredientRepository()
val ingredient = mockIngredientRepository.getOne()

val r001incredients = listOf(
    Ingredient(1,"Tomate"),
    Ingredient(2, "Gurke"),
    Ingredient(3, "Nudeln")
)

val r001 = Recipe(
    1,
    "Bananenbrot",
    mapOf(ingredient to 2),
    r001steps)

