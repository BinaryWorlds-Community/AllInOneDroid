package com.example.allinone.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.allinone.data.AllInOneUiState
import com.example.allinone.data.AppDatabase
import com.example.allinone.data.dao.StorageItemDao
import com.example.allinone.data.entities.ShoppingItem
import com.example.allinone.data.entities.StorageItem
import com.example.allinone.di.AppModule
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AllInOneViewModel (
    val appModule : AppModule,
    private val storageItemDao: StorageItemDao // might be a better way to provide the dao to the viewmodel...
): ViewModel(){

   val uiState: StateFlow<AllInOneUiState> =
       appModule.userPreferencesRepo.isDarkMode.map { isDarkMode ->
           AllInOneUiState(
               isDarkMode = isDarkMode
           )
       }.stateIn(
           scope = viewModelScope,
           started = SharingStarted.WhileSubscribed(5_000),
           initialValue = AllInOneUiState()
       )

   private val _storageItem = MutableLiveData<MutableList<StorageItem>>()
    private val _storageItemSuggestions = MutableLiveData<List<StorageItem>>()
   private val _shoppingItem = MutableLiveData<MutableList<ShoppingItem>>()

   val storageItem : LiveData<MutableList<StorageItem>> get() = _storageItem
    val storageItemSuggestions : LiveData<List<StorageItem>> = _storageItemSuggestions
   val shoppingItem : LiveData<MutableList<ShoppingItem>> get() = _shoppingItem
    fun selectDarkMode(isDarkMode: Boolean) {
        viewModelScope.launch {
            appModule.userPreferencesRepo.saveDarkModePreference(isDarkMode)
        }
    }

   fun loadStorageItems(){
       viewModelScope.launch {
           val result = appModule.storageRepo.getAll()
           _storageItem.postValue(result.toMutableList())
       }
   }

    fun fetchStorageItemSuggestions(query: String) {
        viewModelScope.launch{
            _storageItemSuggestions.value = storageItemDao.getStorageItemNames(query)
        }
    }
    fun updateStorageItems(newData : MutableList<StorageItem>){
        _storageItem.postValue(newData)
        appModule.storageRepo.updateMultiple(newData.toList())
    }

    suspend fun updateStorageItem(entry : StorageItem){
        appModule.storageRepo.updateOne(entry)
        _storageItem.value = appModule.storageRepo. getAll().toMutableList()
    }

    suspend fun addStorageItem(newEntry : StorageItem){
        appModule.storageRepo.createOne(newEntry)
        _storageItem.value = appModule.storageRepo.getAll().toMutableList()
    }

    fun getRndStorageItem() : StorageItem {
        return appModule.storageRepo.getOne()
    }

    fun loadShoppingItems(){
        viewModelScope.launch {
            val result = appModule.shoppingRepo.getAll()
            _shoppingItem.postValue(result.toMutableList())
        }
    }

    fun updateShoppingItems(newData : MutableList<ShoppingItem>){
        _shoppingItem.postValue(newData)
        appModule.shoppingRepo.updateMultiple(newData.toList())
    }

    suspend fun updateShoppingItem(entry : ShoppingItem){
        appModule.shoppingRepo.updateOne(entry)
        _shoppingItem.value = appModule.shoppingRepo. getAll().toMutableList()
    }

    suspend fun addShoppingItem(newEntry : ShoppingItem){
        appModule.shoppingRepo.createOne(newEntry)
        _shoppingItem.value = appModule.shoppingRepo.getAll().toMutableList()
    }

    fun getRndShoppingItem() : ShoppingItem {
        return appModule.shoppingRepo.getOne()
    }
}
