package com.example.allinone.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.allinone.App
import com.example.allinone.R
import com.example.allinone.data.entities.ShoppingItem
import com.example.allinone.ui.components.*
import com.example.allinone.ui.viewmodel.AllInOneViewModel
import com.example.allinone.ui.viewmodel.viewModelFactory
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllInOneShoppingScreen(
    modifier: Modifier = Modifier,
    onHomeButtonClicked: () -> Unit = {},
) {
    val viewModel = viewModel<AllInOneViewModel>(
        factory = viewModelFactory {
            AllInOneViewModel(App.appModule)
        }
    )
    val shoppingItems by viewModel.shoppingItem.observeAsState(initial = emptyList())
    viewModel.loadShoppingItems()

    var isDialogOpen by remember { mutableStateOf(false) }

    Scaffold (
        topBar = {
            TopAppBar(title = { Text(text = stringResource(id = R.string.shopping_list)) })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.viewModelScope.launch {
                    viewModel.addShoppingItem(
                        ShoppingItem(ingredientId = 1, isBought = false , amount = 10.0f)
                    )
                }
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(shoppingItems.size) {
                val shoppingItem = shoppingItems[it]
                ShoppingItemRow(
                    id = shoppingItem.id,
                    itemName = viewModel.appModule.ingredientRepo.getByID(shoppingItem.ingredientId)?.name ?: "Not Found",
                    amount = shoppingItem.amount,
                    unit = "kg",
                    itemIcon = R.drawable.home
                )
            }
        }
    }
}