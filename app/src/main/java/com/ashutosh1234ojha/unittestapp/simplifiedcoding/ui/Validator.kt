package com.ashutosh1234ojha.unittestapp.simplifiedcoding.ui

/**
 * Created by Ashutosh Ojha on 17,December,2021
 */
object Validator {
    fun validateInput(amount: Int, description: String) =
        !(amount <= 0 || description.isEmpty())
}