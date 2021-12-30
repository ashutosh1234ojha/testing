package com.ashutosh1234ojha.unittestapp.junit5

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


/**
 * Created by Ashutosh Ojha on 29,December,2021
 */
@RunWith(JUnit4::class)
class ContactManagerTest {
    lateinit var contactManager: ContactManager


    companion object{

    }

    @Before
    fun setUp() {
        contactManager = ContactManager()
    }

    @Test
    fun whenInputIsValid() {
        contactManager.addContact("ashu", "Ojha", "0896872259")
        Assert.assertTrue(contactManager.getAllContacts()!!.size == 1)

    }

    @Test
    @DisplayName("Should Not Create Contact When First Name is Null")
    fun shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
        Assertions.assertThrows(
            java.lang.RuntimeException::class.java
        ) {
            contactManager.addContact(
                null,
                "Doe",
                "0123456789"
            )
        }
    }


}
