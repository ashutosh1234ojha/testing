package com.ashutosh1234ojha.unittestapp.simplifiedcoding.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ashutosh1234ojha.unittestapp.databinding.ItemSpendBinding
import com.ashutosh1234ojha.unittestapp.simplifiedcoding.data.Spend

/**
 * Created by Ashutosh Ojha on 17,December,2021
 */
class SpendsAdapter : RecyclerView.Adapter<SpendsAdapter.SpendViewHolder>() {

    var spends: List<Spend> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SpendViewHolder(
        ItemSpendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: SpendViewHolder, position: Int) = with(holder.binding) {
        textViewDate.text = spends[position].date.toReadableString()
        textViewDesc.text = spends[position].description
        textViewAmount.text = spends[position].amount.toString()
    }

    override fun getItemCount() = spends.size

    fun getItemAtPosition(position: Int) = spends[position]

    inner class SpendViewHolder(val binding: ItemSpendBinding) :
        RecyclerView.ViewHolder(binding.root)
}