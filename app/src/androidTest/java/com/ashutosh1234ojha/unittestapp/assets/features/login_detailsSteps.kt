package com.ashutosh1234ojha.unittestapp.assets.features

import com.ashutosh1234ojha.unittestapp.simplifiedcoding.ui.AddSpendFragmentTest
import cucumber.api.java.`is`.En
import cucumber.api.java.en.Given



class login_detailsSteps {
    private val robot = AddSpendFragmentTest()

    @Given("^I start the application$")
    fun i_start_app() {
        robot.testAddingSpend()
    }

}