/**
 * Dice Rolling Simulator
 *
 * Objective:
 * Create a Kotlin program that simulates rolling two dice.
 * The program generates random numbers between 1 and 6
 * and prints the result of each roll.
 * If both dice show the same number, a special message is displayed.
 */

import kotlin.random.Random

// Function to roll a single die
fun rollDie(): Int {
    return Random.nextInt(1, 7)
}

// Function to roll two dice and print results
fun rollDicePair() {
    val dice1 = rollDie()
    val dice2 = rollDie()

    println("Dice 1: $dice1")
    println("Dice 2: $dice2")

    if (dice1 == dice2) {
        println("🎉 Doubles! Both dice show $dice1!")
    } else {
        println("No match this time. Try again!")
    }
}

// Main function
fun main() {

    println("================================")
    println("        Dice Roll Simulator     ")
    println("================================")

    rollDicePair()

    println("================================")
    println("Thanks for playing!")
}