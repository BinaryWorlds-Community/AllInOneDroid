package com.example.allinone.data.entities

import androidx.room.Embedded
import androidx.room.Relation

data class ItemWithCategory(
    @Embedded val item: Item,
    @Relation(
        parentColumn = "id",
        entityColumn = "categoryId",
    )
    val category: ItemCategory
)

