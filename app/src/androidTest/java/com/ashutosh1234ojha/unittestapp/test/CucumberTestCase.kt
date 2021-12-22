package com.ashutosh1234ojha.unittestapp.test

import cucumber.api.CucumberOptions

/**
 * Created by Ashutosh Ojha on 20,December,2021
 */

@CucumberOptions(features = ["features"],
    glue = ["com.sniper.bdd.cucumber.steps"],
    tags = ["@e2e", "@smoke"])
@SuppressWarnings("unused")
class CucumberTestCase

