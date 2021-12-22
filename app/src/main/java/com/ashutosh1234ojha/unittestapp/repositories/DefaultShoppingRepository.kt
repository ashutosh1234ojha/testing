package com.ashutosh1234ojha.unittestapp.repositories

import androidx.lifecycle.LiveData
import com.ashutosh1234ojha.unittestapp.data.local.ShoppingDao
import com.ashutosh1234ojha.unittestapp.data.local.ShoppingItem
import com.ashutosh1234ojha.unittestapp.data.remote.PixabayAPI
import com.ashutosh1234ojha.unittestapp.data.remote.responses.ImageResponse
import com.ashutosh1234ojha.unittestapp.others.Resource
import javax.inject.Inject

/**
 * Created by Ashutosh Ojha on 29,October,2021
 */
class DefaultShoppingRepository @Inject constructor(
    private val shoppingDao: ShoppingDao,
    private val pixabayAPI: PixabayAPI
) : ShoppingRepository {

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.insertShoppingItem(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.deleteShoppingItem(shoppingItem)
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
        return shoppingDao.observeAllShoppingItems()
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return shoppingDao.observeTotalPrice()
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return try {
            val response = pixabayAPI.searchForImage(imageQuery)
            if(response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("An unknown error occured", null)
            } else {
                Resource.error("An unknown error occured", null)
            }
        } catch(e: Exception) {
            Resource.error("Couldn't reach the server. Check your internet connection", null)
        }
    }
}
