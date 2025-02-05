package com.example.allinone.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.allinone.App
import com.example.allinone.R
import com.example.allinone.ui.theme.AllInOneTheme
import com.example.allinone.ui.viewmodel.AllInOneViewModel
import com.example.allinone.ui.viewmodel.viewModelFactory

@Composable
fun StorageItemRow(
    id: Int,
    itemName: String,
    amount: Float,
    unit: String,
    locationIcon: Int,
    itemIcon: Int
) {
    val viewModel = viewModel<AllInOneViewModel>(
        factory = viewModelFactory {
            AllInOneViewModel(App.appModule)
        }
    )


    var curAmount by remember { mutableFloatStateOf(amount) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(0.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(0.dp)

        ) {
            // Item icon
            Image(
                modifier = Modifier
                    .size(36.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = itemIcon),
                contentDescription = null
            )
            // Name
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 24.dp)
                    .align(Alignment.CenterVertically),
                text = itemName,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,

            )
            // Amount
            TextField(
                modifier = Modifier
                    .weight(0.5f),
                value = curAmount.toString(),
                onValueChange = {
                    curAmount = if(it.isEmpty()){
                        0f
                    }else {
                        it.toFloatOrNull() ?: curAmount
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Decimal,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions (
                    onDone = {
                        // viewModel.updateStorageItem(StorageItem(id,"itemName"))
                    }
                )
            )
            // Unit
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                text = unit
            )
            Spacer(modifier = Modifier.weight(0.5f))
            // Location icon
            Image(
                modifier = Modifier
                    .padding(end = 28.dp)
                    .size(24.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = locationIcon),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun StorageItemPreview(){
    AllInOneTheme {
        StorageItemRow(
            id = 1,
            itemName = "Item 1",
            amount = 5f,
            unit = "kg",
            locationIcon = R.drawable.storage,
            itemIcon = R.drawable.home
        )
    }
}