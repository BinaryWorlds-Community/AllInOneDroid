package com.example.allinone.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.allinone.R

data class RecipeStep(
    @StringRes val descriptionResourceId: Int,
    @StringRes val ingredientsResourceId: Int,
    @DrawableRes val imageResourceId: Int
)

val r001steps = listOf<RecipeStep>(
            RecipeStep(R.string.r001s01, R.string.r001i01, R.drawable.r001p01),
            RecipeStep(R.string.r001s02, R.string.r001i02, R.drawable.r001p02),
            RecipeStep(R.string.r001s03, R.string.r001i03, R.drawable.r001p03),
            RecipeStep(R.string.r001s04, R.string.r001i04, R.drawable.r001p04),
            RecipeStep(R.string.r001s05, R.string.r001i05, R.drawable.r001p05),
            RecipeStep(R.string.r001s06, R.string.r001i06, R.drawable.r001p06),
            RecipeStep(R.string.r001s07, R.string.r001i07, R.drawable.r001p07)
)
