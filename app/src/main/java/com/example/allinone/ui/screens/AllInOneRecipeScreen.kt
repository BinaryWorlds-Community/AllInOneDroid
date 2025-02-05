package com.example.allinone.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.allinone.R
import com.example.allinone.data.RecipeStep
import com.example.allinone.ui.theme.AllInOneTheme

@Composable
fun AllInOneRecipeScreen(
    modifier: Modifier = Modifier,
    //steps: List<RecipeStep>
) {
    val steps: List<RecipeStep> =
        listOf(
        RecipeStep(R.string.r001s01, R.string.r001i01, R.drawable.r001p01),
        RecipeStep(R.string.r001s02, R.string.r001i02, R.drawable.r001p02),
        RecipeStep(R.string.r001s03, R.string.r001i03, R.drawable.r001p03),
        RecipeStep(R.string.r001s04, R.string.r001i04, R.drawable.r001p04),
        RecipeStep(R.string.r001s05, R.string.r001i05, R.drawable.r001p05),
        RecipeStep(R.string.r001s06, R.string.r001i06, R.drawable.r001p06),
        RecipeStep(R.string.r001s07, R.string.r001i07, R.drawable.r001p07),
    )

    LazyColumn(
        modifier = modifier
    ) {
        items(steps) {step ->
            recipeCard(
                step = step,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun recipeCard(
    step: RecipeStep,
    modifier: Modifier = Modifier
){
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(step.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(step.descriptionResourceId),
                modifier = Modifier.padding(
                    top = 4.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 4.dp
                ),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = stringResource(step.ingredientsResourceId),
                modifier = Modifier.padding(
                    top = 4.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 4.dp
                ),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun AllInOneRecipeScreenPreview(){
    AllInOneTheme {
        AllInOneRecipeScreen(
            modifier = Modifier,
            //steps = loadSteps(),
        )
    }
}