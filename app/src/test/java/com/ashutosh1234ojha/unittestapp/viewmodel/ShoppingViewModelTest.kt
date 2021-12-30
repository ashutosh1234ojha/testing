package com.ashutosh1234ojha.unittestapp.viewmodel

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ashutosh1234ojha.unittestapp.data.local.ShoppingItem
import com.ashutosh1234ojha.unittestapp.getOrAwaitValueTest
import com.ashutosh1234ojha.unittestapp.others.Constants
import com.ashutosh1234ojha.unittestapp.others.Status
import com.ashutosh1234ojha.unittestapp.repositories.FakeShoppingRepository
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.lang.StringBuilder


/**
 * Created by Ashutosh Ojha on 04,November,2021
 */
class ShoppingViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()//It  will make sure every task run in
    //same thread, one after another

    private lateinit var viewModel: ShoppingViewModel

    @Before
    fun setup() {
        viewModel = ShoppingViewModel(FakeShoppingRepository())
    }

    @Test
    fun insertShoppingItemWithEmptyFieldReturnError() {
        viewModel.insertShoppingItem("", "", "")
        val value=viewModel.insertShoppingItemStatus.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
        assertThat(value.getContentIfNotHandled()?.status)
    }

    @Test
    fun insertShoppingItemNameTooLongReturnError(){
        val  string= buildString{
            for(i  in 1..Constants.MAX_NAME_LENGTH+1){
                append(1)
            }
        }//Here we are  using loop for creating string  because  in future if  our  String  length
        //Validation increases we dont  have  to do  anything because we are using  constant value here in loop
        viewModel.insertShoppingItem(string,"5","3.0")
        val value=viewModel.insertShoppingItemStatus.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun insertShoppingItemPriceTooLongReturnError(){
        val  string= buildString{
            for(i  in 1..Constants.MAX_PRICE_LENGTH+1){
                append(1)
            }
        }//Here we are  using loop for creating string  because  in future if  our  String  length
        //Validation increases we dont  have  to do  anything because we are using  constant value here in loop
        viewModel.insertShoppingItem("name","5",string)
        val value=viewModel.insertShoppingItemStatus.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }
    @Test
    fun insertShoppingItemAmountTooHighReturnError(){
        viewModel.insertShoppingItem("name","55555444434345555","4.3")
        val value=viewModel.insertShoppingItemStatus.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun insertShoppingItemValidReturnSuccess(){
        viewModel.insertShoppingItem("name","5","4.3")
        val value=viewModel.insertShoppingItemStatus.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.SUCCESS)
    }
}