package com.example.allinone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.allinone.App
import com.example.allinone.R
import com.example.allinone.data.AppDatabase
import com.example.allinone.data.entities.StorageItem
import com.example.allinone.ui.components.*
import com.example.allinone.ui.theme.AllInOneTheme
import com.example.allinone.ui.viewmodel.AllInOneViewModel
import com.example.allinone.ui.viewmodel.viewModelFactory
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllInOneStorageScreen(
    modifier: Modifier = Modifier
) {
    val viewModel = viewModel<AllInOneViewModel>(
        factory = viewModelFactory {
            AllInOneViewModel(App.appModule)
        }
    )

    val storageItems by viewModel.storageItem.observeAsState(initial = emptyList())
    viewModel.loadStorageItems()

    var isDialogOpen by remember { mutableStateOf(false) }
    var newStorageItemName by remember { mutableStateOf("") }
    var newStorageItemAmount by remember { mutableFloatStateOf(0f) }

    Scaffold (
        topBar = {
                 TopAppBar(title = { Text(text = stringResource(id = R.string.storage)) })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { isDialogOpen = true }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ){ innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            items(storageItems.size){
                    val storageItem = storageItems[it]
                    StorageItemRow(
                        id = storageItem.id,
                        itemName = storageItem.ingredientName, //viewModel.appModule.ingredientRepo.getByID(storageItem.ingredientId)?.name
                            //?: "Not Found",
                        amount = storageItem.amount,
                        unit = "kg",
                        locationIcon = R.drawable.storage,
                        itemIcon = R.drawable.home
                    )
                }
            }
        if(isDialogOpen) {
            Dialog(onDismissRequest = { isDialogOpen = false },
                content = {
                    Column(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.background)
                            .padding(16.dp)
                            .fillMaxWidth()
                    ){
                        TextField(
                            value = newStorageItemName,
                            onValueChange = { newStorageItemName = it },
                            label = { Text("Enter Ingredient") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        TextField(
                            value = newStorageItemAmount.toString(),
                            onValueChange = {
                                newStorageItemAmount = if(it.isEmpty()){
                                    0f
                                }else {
                                    it.toFloatOrNull() ?: newStorageItemAmount
                                }
                            },
                            label = { Text("Enter Amount") },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Decimal,
                                imeAction = ImeAction.Done
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Button(onClick = {
                            viewModel.viewModelScope.launch {
                                viewModel.addStorageItem(StorageItem(ingredientName = newStorageItemName, amount = newStorageItemAmount))
                            }
                            isDialogOpen = false
                            newStorageItemAmount = 0f
                            newStorageItemName = ""
                        },
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            Text(text = "Add Ingredient")
                        }

                        Button(onClick = {
                            isDialogOpen = false
                            newStorageItemAmount = 0f
                            newStorageItemName = ""
                        },
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            Text(text = "Cancel")
                        }
                    }
                })
        }
    }
}

@Preview
@Composable
fun AllInOneStorageScreenPreview(){
    AllInOneTheme {
        AllInOneStorageScreen()
    }
}