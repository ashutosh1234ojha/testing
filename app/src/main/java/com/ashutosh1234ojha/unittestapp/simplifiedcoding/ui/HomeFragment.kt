package com.ashutosh1234ojha.unittestapp.simplifiedcoding.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ashutosh1234ojha.unittestapp.R
import com.ashutosh1234ojha.unittestapp.databinding.FragmentHomeBinding

/**
 * Created by Ashutosh Ojha on 17,December,2021
 */

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val spendsAdapter = SpendsAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding.recyclerViewSpends.also {
            it.layoutManager = LinearLayoutManager(requireContext())
            it.setHasFixedSize(true)
            it.adapter = spendsAdapter
        }

        binding.buttonAddSpend.setOnClickListener {
            findNavController().navigate(R.id.addSpendFragment)
        }

        viewModel.last20SpendsLiveData.observe(viewLifecycleOwner) { spends ->
            spendsAdapter.spends = spends
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getLast20Spends()
    }
}