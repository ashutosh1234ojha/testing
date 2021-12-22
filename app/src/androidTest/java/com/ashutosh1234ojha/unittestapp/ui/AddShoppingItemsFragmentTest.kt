package com.ashutosh1234ojha.unittestapp.ui

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.pressBack
import androidx.test.filters.MediumTest
import com.ashutosh1234ojha.unittestapp.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify

/**
 * Created by Ashutosh Ojha on 14,November,2021
 */
@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class AddShoppingItemsFragmentTest{
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun pressBackButton_popBackStack(){
        val navigationController = Mockito.mock(NavController::class.java)
        launchFragmentInHiltContainer<AddShoppingItemsFragment> {
            Navigation.setViewNavController(requireView(), navigationController)
        }
        pressBack()
        verify(navigationController).popBackStack()
    }
}