package com.ashutosh1234ojha.unittestapp.junit5

import java.lang.RuntimeException
import java.util.concurrent.ConcurrentHashMap

/**
 * Created by Ashutosh Ojha on 29,December,2021
 */
class ContactManager {
    var contactList: MutableMap<String, Contact> = ConcurrentHashMap<String, Contact>()

    fun addContact(firstName: String?, lastName: String?, phoneNumber: String?) {
        val contact = Contact(firstName, lastName, phoneNumber)
        validateContact(contact)
        checkIfContactAlreadyExist(contact)
        contactList[generateKey(contact)] = contact
    }

    fun getAllContacts(): Collection<Contact>? {
        return contactList.values
    }

    private fun checkIfContactAlreadyExist(contact: Contact) {
        if (contactList.containsKey(generateKey(contact))) throw RuntimeException("Contact Already Exists")
    }

    private fun validateContact(contact: Contact) {
        contact.validateFirstName()
        contact.validateLastName()
        contact.validatePhoneNumber()
    }

    private fun generateKey(contact: Contact): String {
        return String.format("%s-%s", contact.getFirstName(), contact.getLastName())
    }
}