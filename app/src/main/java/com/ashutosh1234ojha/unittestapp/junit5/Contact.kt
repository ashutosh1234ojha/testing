package com.ashutosh1234ojha.unittestapp.junit5

import java.lang.RuntimeException

/**
 * Created by Ashutosh Ojha on 29,December,2021
 */
class Contact(var firstName: String?,var lastName: String?,var phoneNumber: String?) {

    @JvmName("getFirstName1")
    fun getFirstName(): String? {
        return firstName
    }

    @JvmName("getLastName1")
    fun getLastName(): String? {
        return lastName
    }

    fun validateFirstName() {
        if (firstName!!.isBlank()) throw RuntimeException("First Name Cannot be null or empty")
    }

    fun validateLastName() {
        if (lastName!!.isBlank()) throw RuntimeException("Last Name Cannot be null or empty")
    }

    fun validatePhoneNumber() {
        if (phoneNumber!!.isBlank()) {
            throw RuntimeException("Phone Name Cannot be null or empty")
        }
        if (phoneNumber!!.length != 10) {
            throw RuntimeException("Phone Number Should be 10 Digits Long")
        }
        if (!phoneNumber!!.matches(Regex(".*\\d.*"))) {
            throw RuntimeException("Phone Number Contain only digits")
        }
        if (!phoneNumber!!.startsWith("0")) {
            throw RuntimeException("Phone Number Should Start with 0")
        }
    }
}