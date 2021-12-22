package com.ashutosh1234ojha.unittestapp.simplifiedcoding.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ashutosh1234ojha.unittestapp.simplifiedcoding.data.SpendsDatabase
import com.ashutosh1234ojha.unittestapp.simplifiedcoding.data.SpendsTrackerDataSource

/**
 * Created by Ashutosh Ojha on 17,December,2021
 */
abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout) {

    protected lateinit var viewModel: SpendViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = SpendsDatabase(requireContext())
        val dataSource = SpendsTrackerDataSource(db.getSpendDao())
        val factory = ViewModelFactory(dataSource)
        viewModel = ViewModelProvider(this, factory).get(SpendViewModel::class.java)
    }
}