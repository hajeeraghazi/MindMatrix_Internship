/**
 * Session 7 Lab: Tip Calculator
 *
 * Objective:
 * Build a console-based tip calculator using Kotlin.
 * The program calculates a tip based on the bill amount
 * and optionally rounds up the tip amount.
 *
 * Concepts Used:
 * - Functions
 * - Conditional logic
 * - Numeric calculations
 * - String formatting
 */

import kotlin.math.ceil

// Function to calculate the tip
fun calculateTip(amount: Double, tipPercent: Double, roundUp: Boolean): Double {
    var tip = amount * tipPercent / 100

    if (roundUp) {
        tip = ceil(tip)
    }

    return tip
}

// Main function
fun main() {

    println("===================================")
    println("          Tip Calculator           ")
    println("===================================")

    // Input bill amount
    print("Enter bill amount: ")
    val amount = readLine()?.toDoubleOrNull() ?: 0.0

    // Input tip percentage
    print("Enter tip percentage: ")
    val tipPercent = readLine()?.toDoubleOrNull() ?: 0.0

    // Ask if user wants to round up
    print("Round up tip? (yes/no): ")
    val roundChoice = readLine()?.lowercase()
    val roundUp = roundChoice == "yes"

    // Calculate tip
    val tip = calculateTip(amount, tipPercent, roundUp)

    // Display result
    println("-----------------------------------")
    println("Bill Amount : ₹%.2f".format(amount))
    println("Tip Amount  : ₹%.2f".format(tip))
    println("Total Pay   : ₹%.2f".format(amount + tip))
    println("-----------------------------------")
}