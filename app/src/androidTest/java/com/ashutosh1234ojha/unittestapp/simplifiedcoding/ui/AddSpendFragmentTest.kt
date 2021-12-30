package com.ashutosh1234ojha.unittestapp.simplifiedcoding.ui

import android.os.Bundle
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ashutosh1234ojha.unittestapp.R
import org.junit.Before
import org.junit.runner.RunWith
import androidx.test.espresso.assertion.ViewAssertions.matches
import org.junit.Test


/**
 * Created by Ashutosh Ojha on 17,December,2021
 */
@RunWith(AndroidJUnit4::class)
class AddSpendFragmentTest{

    private lateinit var scenario: FragmentScenario<AddSpendFragment>

    @Before
    fun setUp(){
        val bundle=Bundle()
        scenario= launchFragmentInContainer(themeResId = R.style.Theme_MaterialComponents)
        scenario.moveToState(Lifecycle.State.STARTED)
    }


    @Test
    fun testAddingSpend(){
        val amount=100
        val desc="enter is good"
        onView(withId(R.id.edit_text_amount)).perform(typeText(amount.toString()))
        onView(withId(R.id.edit_text_description)).perform(typeText(desc))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.button_add)).perform(click())
        //this  the text_view_success_message is "Spend Added" then it  means our  text  case  is passed
        onView(withId(R.id.text_view_success_message)).check(matches(withText("Spend Added")))
    }
}