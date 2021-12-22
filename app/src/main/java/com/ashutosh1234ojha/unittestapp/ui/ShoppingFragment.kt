package com.ashutosh1234ojha.unittestapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ashutosh1234ojha.unittestapp.R
import com.ashutosh1234ojha.unittestapp.repositories.DefaultShoppingRepository
import com.ashutosh1234ojha.unittestapp.viewmodel.MyViewModelFactory
import com.ashutosh1234ojha.unittestapp.viewmodel.ShoppingViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/**
 * Created by Ashutosh Ojha on 04,November,2021
 */
@AndroidEntryPoint
class ShoppingFragment : Fragment(R.layout.fragment_shopping) {


    //        @Inject
    lateinit var viewModel: ShoppingViewModel

    @Inject
    lateinit var repository: DefaultShoppingRepository


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(requireActivity()).get(ShoppingViewModel::class.java)
        viewModel = ViewModelProvider(
            requireActivity(),
            MyViewModelFactory(repository)
        ).get(
            ShoppingViewModel::class.java
        )


        val fabAddShoppingItem = view.findViewById<FloatingActionButton>(R.id.fabAddShoppingItem)
        fabAddShoppingItem.setOnClickListener {
            findNavController().navigate(R.id.action_shoppingFragment_to_addShoppingItemsFragment)
        }
    }
}