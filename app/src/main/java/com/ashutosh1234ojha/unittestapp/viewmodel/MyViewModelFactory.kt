package com.ashutosh1234ojha.unittestapp.viewmodel

import androidx.lifecycle.ViewModel

import androidx.lifecycle.ViewModelProvider
import com.ashutosh1234ojha.unittestapp.repositories.ShoppingRepository


/**
 * Created by Ashutosh Ojha on 14,November,2021
 */
class MyViewModelFactory(shoppingRepository: ShoppingRepository) :
    ViewModelProvider.Factory {
    private var mShoppingRepository: ShoppingRepository? = null

//    override fun <T : ViewModel?> create(modelClass: Class<T>?): T {
//        return ShoppingViewModel(mShoppingRepository) as T
//    }

    init {
        mShoppingRepository = shoppingRepository
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(mShoppingRepository!!) as T
    }
}