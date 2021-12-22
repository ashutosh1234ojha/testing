package com.ashutosh1234ojha.unittestapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ashutosh1234ojha.unittestapp.R
import com.ashutosh1234ojha.unittestapp.viewmodel.ShoppingViewModel

/**
 * Created by Ashutosh Ojha on 04,November,2021
 */
class ImagePickFragment :Fragment(R.layout.fragment_image_pick) {
    lateinit var viewModel: ShoppingViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ShoppingViewModel::class.java)
    }
}