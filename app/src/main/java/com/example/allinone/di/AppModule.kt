package com.example.allinone.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.allinone.data.AppDatabase
import com.example.allinone.data.Ingredient
import com.example.allinone.data.Recipe
import com.example.allinone.data.entities.ShoppingItem
import com.example.allinone.data.entities.StorageItem
import com.example.allinone.data.repositories.IRepository
import com.example.allinone.data.repositories.MockIngredientRepository
import com.example.allinone.data.repositories.MockRecipeRepository
import com.example.allinone.data.repositories.RoomShoppingItemRepository
import com.example.allinone.data.repositories.RoomStorageItemRepository
import com.example.allinone.data.repositories.UserPreferencesRepository

interface AppModule{
    val ingredientRepo : IRepository<Ingredient>
    val recipeRepo : IRepository<Recipe>
    val storageRepo : IRepository<StorageItem>
    val shoppingRepo : IRepository<ShoppingItem>
    val userPreferencesRepo: UserPreferencesRepository
}

private const val DARK_MODE_PREFERENCE_NAME = "dark_mode_preferences"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = DARK_MODE_PREFERENCE_NAME
)
class AppModuleImpl (private val appContext : Context
) : AppModule{
    override val ingredientRepo: IRepository<Ingredient> by lazy {
        MockIngredientRepository()
    }
    override val recipeRepo: IRepository<Recipe> by lazy {
        MockRecipeRepository()
    }
    override val storageRepo: IRepository<StorageItem> by lazy {
        RoomStorageItemRepository(AppDatabase.getInstance(appContext))
        //MockStorageItemRepository()
    }
    override val shoppingRepo: IRepository<ShoppingItem> by lazy {
        RoomShoppingItemRepository(AppDatabase.getInstance(appContext))
        //MockShoppingItemRepository()
    }
    override val userPreferencesRepo = UserPreferencesRepository(appContext.dataStore)
}