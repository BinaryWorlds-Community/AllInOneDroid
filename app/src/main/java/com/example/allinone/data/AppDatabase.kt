package com.example.allinone.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.allinone.data.dao.RecipeDao
import com.example.allinone.data.dao.ShoppingItemDao
import com.example.allinone.data.dao.StorageItemDao
import com.example.allinone.data.entities.Recipe
import com.example.allinone.data.entities.RecipeStep
import com.example.allinone.data.entities.ShoppingItem
import com.example.allinone.data.entities.StorageItem

@Database(
    entities = [StorageItem::class, ShoppingItem::class, Recipe::class, RecipeStep::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun storageItemDao() : StorageItemDao
    abstract fun shoppingItemDao() : ShoppingItemDao
    abstract fun recipeDao() : RecipeDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "my_database4"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}