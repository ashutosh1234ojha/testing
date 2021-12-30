package com.ashutosh1234ojha.unittestapp.simplifiedcoding.ui

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import com.ashutosh1234ojha.unittestapp.R
import org.junit.Test


/**
 * Created by Ashutosh Ojha on 19,December,2021
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTwoTest {

    private lateinit var scenario: ActivityScenario<MainActivityTwo>

    @Before
    fun setup() {
        scenario = launchActivity()
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun testMainActivityVisibility() {
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun testAddAndViewSpend() {


        onView(withId(R.id.button_add_spend)).perform(click())
        val amount = 100
        val desc = "Bought Eggs"
        onView(withId(R.id.edit_text_amount)).perform(ViewActions.typeText(amount.toString()))
        onView(withId(R.id.edit_text_description)).perform(ViewActions.typeText(desc))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.button_add)).perform(click())
        onView(withText(amount.toString())).check(matches(isDisplayed()))
        onView(withText(desc)).check(matches(isDisplayed()))
    }


}