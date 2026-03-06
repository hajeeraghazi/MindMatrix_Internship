/**
 * =====================================================
 * Session 12 Lab: Theme Switcher & Progress Animation
 * =====================================================
 *
 * Objective:
 * Build a Kotlin console application that simulates:
 * 1. Theme switching (Light / Dark / Ocean)
 * 2. A simple animated progress bar
 *
 * Concepts Used:
 * - Data Classes
 * - Functions
 * - Loops
 * - Lists
 * - Basic animation logic using delays
 * =====================================================
 */

import kotlin.concurrent.thread

// -----------------------------
// Data Class for Theme
// -----------------------------
data class Theme(
    val name: String,
    val primaryColor: String,
    val backgroundColor: String
)

// -----------------------------
// Function to Apply Theme
// -----------------------------
fun applyTheme(theme: Theme) {
    println("\n--- Applying Theme ---")
    println("Theme Name: ${theme.name}")
    println("Primary Color: ${theme.primaryColor}")
    println("Background Color: ${theme.backgroundColor}")
}

// -----------------------------
// Function to Animate Progress
// -----------------------------
fun animateProgress() {
    println("\nLoading...")

    for (i in 1..20) {
        val bar = "#".repeat(i)
        val space = " ".repeat(20 - i)

        print("\r[$bar$space] ${i * 5}%")
        Thread.sleep(150)
    }

    println("\nCompleted!")
}

// -----------------------------
// Main Function
// -----------------------------
fun main() {

    println("========== Theme Switcher ==========")

    val lightTheme = Theme("Light", "Blue", "White")
    val darkTheme = Theme("Dark", "Cyan", "Black")
    val oceanTheme = Theme("Ocean", "Teal", "Deep Blue")

    val themes = listOf(lightTheme, darkTheme, oceanTheme)

    // Apply themes one by one
    for (theme in themes) {
        applyTheme(theme)
        animateProgress()
    }

    println("\nAll themes demonstrated successfully!")
}