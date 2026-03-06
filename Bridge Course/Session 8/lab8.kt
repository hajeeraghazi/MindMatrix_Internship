/**
 * Session 8 Lab: Console-Based Art Gallery Navigator
 *
 * Objective:
 * Build a console program that allows the user to navigate
 * through artworks using Next and Previous commands.
 *
 * Concepts Used:
 * - Data Classes
 * - Lists
 * - Functions
 * - Conditional logic
 * - Wrapping navigation (first ↔ last artwork)
 */

// Data class to store artwork details
data class Artwork(
    val title: String,
    val artist: String,
    val year: Int
)

// Function to display artwork
fun displayArtwork(artwork: Artwork) {
    println("----------------------------------")
    println("Title  : ${artwork.title}")
    println("Artist : ${artwork.artist}")
    println("Year   : ${artwork.year}")
    println("----------------------------------")
}

fun main() {

    println("===================================")
    println("       Art Gallery Navigator       ")
    println("===================================")

    // List of artworks
    val gallery = listOf(
        Artwork("Starry Night", "Vincent van Gogh", 1889),
        Artwork("Mona Lisa", "Leonardo da Vinci", 1503),
        Artwork("The Persistence of Memory", "Salvador Dalí", 1931),
        Artwork("The Scream", "Edvard Munch", 1893),
        Artwork("Girl with a Pearl Earring", "Johannes Vermeer", 1665)
    )

    var index = 0

    while (true) {

        // Show current artwork
        displayArtwork(gallery[index])

        println("Options: [N]ext  [P]revious  [Q]uit")
        print("Enter choice: ")

        when (readLine()?.lowercase()) {

            "n" -> {
                index = (index + 1) % gallery.size   // wrap to first
            }

            "p" -> {
                index = if (index - 1 < 0) gallery.size - 1 else index - 1
            }

            "q" -> {
                println("Exiting Art Gallery...")
                break
            }

            else -> println("Invalid option. Try again.")
        }
    }
}