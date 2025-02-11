package com.example.allinone.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.allinone.data.entities.RecipeWithSteps

@Dao
interface RecipeDao{
    @Transaction
    @Query("SELECT * FROM recipes")
    suspend fun getAllRecipes(): MutableList<RecipeWithSteps>
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertRecipe(recipeWithSteps: RecipeWithSteps)
//    @Update
//    suspend fun updateRecipe(recipeWithSteps: RecipeWithSteps)
//    @Delete
//    suspend fun deleteRecipe(recipeWithSteps: RecipeWithSteps)
}