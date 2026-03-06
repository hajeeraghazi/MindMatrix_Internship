/**
 * Session 5 Lab: Console-Based Contact Manager
 *
 * Objective:
 * Create a console-based contact manager using Kotlin.
 * The program demonstrates the use of:
 * - Data Classes
 * - Null Handling
 * - Higher-Order Functions
 * - Reusable Functions
 *
 * Features:
 * 1. Store contact details (name, phone, email, favorite status)
 * 2. Display all contacts
 * 3. Filter favorite contacts
 * 4. Filter contacts that have email addresses
 */

// ---------------------------------------
// Data Class Definition
// ---------------------------------------

data class Contact(
    val name: String,
    val phone: String?,
    val email: String?,
    val isFavorite: Boolean
)

// ---------------------------------------
// Function to Display Contacts
// ---------------------------------------

fun displayContacts(title: String, contacts: List<Contact>) {

    println("\n===================================")
    println(title)
    println("===================================")

    if (contacts.isEmpty()) {
        println("No contacts found.")
        return
    }

    contacts.forEach { contact ->
        println("Name     : ${contact.name}")
        println("Phone    : ${contact.phone ?: "Not Available"}")
        println("Email    : ${contact.email ?: "Not Available"}")
        println("Favorite : ${if (contact.isFavorite) "Yes" else "No"}")
        println("-----------------------------------")
    }
}

// ---------------------------------------
// Higher-Order Function for Filtering
// ---------------------------------------

fun filterContacts(
    contacts: List<Contact>,
    condition: (Contact) -> Boolean
): List<Contact> {
    return contacts.filter(condition)
}

// ---------------------------------------
// Main Function
// ---------------------------------------

fun main() {

    println("===================================")
    println("      Kotlin Contact Manager       ")
    println("===================================")

    // Create a list of contacts
    val contacts = listOf(
        Contact("Aisha Khan", "9876543210", "aisha@email.com", true),
        Contact("Rahul Sharma", "9123456780", null, false),
        Contact("Neha Patel", null, "neha@email.com", true),
        Contact("Arjun Mehta", "9988776655", "arjun@email.com", false),
        Contact("Sara Ali", null, null, false)
    )

    // Display all contacts
    displayContacts("All Contacts", contacts)

    // Display favorite contacts
    val favoriteContacts = filterContacts(contacts) { it.isFavorite }
    displayContacts("Favorite Contacts", favoriteContacts)

    // Display contacts with email
    val emailContacts = filterContacts(contacts) { it.email != null }
    displayContacts("Contacts with Email", emailContacts)

    println("\nProgram Finished.")
}