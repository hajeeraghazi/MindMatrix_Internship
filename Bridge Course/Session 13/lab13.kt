/**
 * =====================================================
 * Session 13 Lab: Superhero Catalog
 * =====================================================
 *
 * Objective:
 * Build a console-based superhero catalog that displays
 * each hero’s name, power, and mission clearly.
 *
 * Concepts Used:
 * - Data classes
 * - Lists
 * - Functions
 * - Clean and readable output formatting
 * =====================================================
 */

// -----------------------------
// Data Class Definition
// -----------------------------
data class Superhero(
    val name: String,
    val power: String,
    val mission: String
)

// -----------------------------
// Function to Display One Hero
// -----------------------------
fun displayHero(hero: Superhero) {
    println("================================")
    println("Hero Name : ${hero.name}")
    println("Power     : ${hero.power}")
    println("Mission   : ${hero.mission}")
    println("================================")
}

// -----------------------------
// Function to Display Catalog
// -----------------------------
fun displayCatalog(heroes: List<Superhero>) {
    println("\n🦸 SUPERHERO CATALOG\n")

    for (hero in heroes) {
        displayHero(hero)
    }
}

// -----------------------------
// Main Function
// -----------------------------
fun main() {

    // Creating superhero list
    val heroes = listOf(
        Superhero(
            "Captain Code",
            "Super Programming",
            "Protect the digital world from bugs"
        ),
        Superhero(
            "Debug Girl",
            "Bug Detection",
            "Find and fix critical software errors"
        ),
        Superhero(
            "Data Master",
            "Data Manipulation",
            "Manage and secure global data systems"
        ),
        Superhero(
            "AI Guardian",
            "Artificial Intelligence",
            "Ensure ethical use of AI technologies"
        )
    )

    // Display catalog
    displayCatalog(heroes)
}