/**
 * =========================================================
 * Session 11 Lab: Zoo Animal Tracker
 * =========================================================
 *
 * Objective:
 * Build a Kotlin console program that demonstrates:
 * - Abstract classes
 * - Inheritance
 * - Interfaces
 * - Polymorphism
 *
 * Animals will perform actions such as:
 * roaring, spraying water, and mimicking words.
 * =========================================================
 */

// ---------------------------------------------------------
// Abstract Base Class
// ---------------------------------------------------------

abstract class Animal(val name: String) {

    abstract fun makeSound()

    fun sleep() {
        println("$name is sleeping.")
    }
}

// ---------------------------------------------------------
// Interface Definitions
// ---------------------------------------------------------

interface Roar {
    fun roar()
}

interface SprayWater {
    fun spray()
}

interface Mimic {
    fun mimic(words: String)
}

// ---------------------------------------------------------
// Lion Class
// ---------------------------------------------------------

class Lion(name: String) : Animal(name), Roar {

    override fun makeSound() {
        println("$name makes a loud growl.")
    }

    override fun roar() {
        println("$name roars loudly!")
    }
}

// ---------------------------------------------------------
// Elephant Class
// ---------------------------------------------------------

class Elephant(name: String) : Animal(name), SprayWater {

    override fun makeSound() {
        println("$name trumpets loudly.")
    }

    override fun spray() {
        println("$name sprays water with its trunk!")
    }
}

// ---------------------------------------------------------
// Parrot Class
// ---------------------------------------------------------

class Parrot(name: String) : Animal(name), Mimic {

    override fun makeSound() {
        println("$name chirps happily.")
    }

    override fun mimic(words: String) {
        println("$name says: \"$words\"")
    }
}

// ---------------------------------------------------------
// Main Function
// ---------------------------------------------------------

fun main() {

    println("====================================")
    println("        Zoo Animal Tracker")
    println("====================================")

    val lion = Lion("Simba")
    val elephant = Elephant("Dumbo")
    val parrot = Parrot("Polly")

    val animals: List<Animal> = listOf(lion, elephant, parrot)

    println("\n--- Animal Sounds ---")
    for (animal in animals) {
        animal.makeSound()
    }

    println("\n--- Special Abilities ---")
    lion.roar()
    elephant.spray()
    parrot.mimic("Hello!")

    println("\n--- Animals Resting ---")
    for (animal in animals) {
        animal.sleep()
    }

    println("\nZoo Simulation Complete.")
}