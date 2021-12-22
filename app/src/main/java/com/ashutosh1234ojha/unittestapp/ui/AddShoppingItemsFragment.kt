package com.ashutosh1234ojha.unittestapp.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ashutosh1234ojha.unittestapp.R
import com.ashutosh1234ojha.unittestapp.others.Event
import com.ashutosh1234ojha.unittestapp.viewmodel.ShoppingViewModel

import androidx.activity.OnBackPressedCallback

import androidx.navigation.fragment.findNavController
import com.ashutosh1234ojha.unittestapp.repositories.DefaultShoppingRepository
import com.ashutosh1234ojha.unittestapp.viewmodel.MyViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by Ashutosh Ojha on 04,November,2021
 */
@AndroidEntryPoint
class AddShoppingItemsFragment : Fragment(R.layout.fragment_add_shopping_items) {

    //    lateinit var viewModel: ShoppingViewModel
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(requireActivity()).get(ShoppingViewModel::class.java)
//    }

    @Inject
    lateinit var repository: DefaultShoppingRepository

    lateinit var viewModel: ShoppingViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(requireActivity()).get(ShoppingViewModel::class.java)
        viewModel = ViewModelProvider(
            requireActivity(),
            MyViewModelFactory(repository)
        ).get(
            ShoppingViewModel::class.java
        )

        val ivShoppingImage = view.findViewById<ImageView>(R.id.ivShoppingImage)
        ivShoppingImage.setOnClickListener {
            findNavController().navigate(
                R.id.action_addShoppingItemsFragment_to_imagePickFragment
            )
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                viewModel.setCurImageUrl("")
                findNavController().popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }
}