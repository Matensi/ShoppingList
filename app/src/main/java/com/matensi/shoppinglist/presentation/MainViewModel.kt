package com.matensi.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matensi.shoppinglist.data.ShopListRepositoryImpl
import com.matensi.shoppinglist.domain.DeleteShopItemUseCase
import com.matensi.shoppinglist.domain.EditShopItemUseCase
import com.matensi.shoppinglist.domain.GetShopListUseCase
import com.matensi.shoppinglist.domain.ShopItem

class MainViewModel: ViewModel() {
    private val repository = ShopListRepositoryImpl
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopListUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem){
        deleteShopListUseCase.deleteShopItem(shopItem)

    }
    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)

    }
}