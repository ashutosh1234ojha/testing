package com.ashutosh1234ojha.unittestapp.simplifiedcoding.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ashutosh1234ojha.unittestapp.simplifiedcoding.data.SpendsTrackerDataSource

/**
 * Created by Ashutosh Ojha on 17,December,2021
 */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val dataSource: SpendsTrackerDataSource
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SpendViewModel(dataSource) as T
    }
}