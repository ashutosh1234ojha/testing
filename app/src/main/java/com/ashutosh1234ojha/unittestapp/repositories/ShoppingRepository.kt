package com.ashutosh1234ojha.unittestapp.repositories

import androidx.lifecycle.LiveData
import com.ashutosh1234ojha.unittestapp.data.local.ShoppingItem
import com.ashutosh1234ojha.unittestapp.data.remote.responses.ImageResponse
import com.ashutosh1234ojha.unittestapp.others.Resource

/**
 * Created by Ashutosh Ojha on 29,October,2021
 */
/**
 * We have created this interface becuase we  want to  have  Main and Test Repository(so that we dont have
 * to  make real api hit and save  time)
 */
interface ShoppingRepository {
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>
}