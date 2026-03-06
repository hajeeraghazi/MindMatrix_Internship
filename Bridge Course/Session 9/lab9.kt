/**
 * =========================================================
 * Session 9 Lab: Inventory Management Program
 * =========================================================
 *
 * Objective:
 * Build a console-based inventory management system using Kotlin.
 *
 * This program demonstrates:
 * - Lists to store inventory items
 * - Maps to calculate totals by category
 * - Generics for reusable functions
 * - Higher-order functions for filtering
 * - Loops for processing collections
 *
 * Features:
 * 1. Display all inventory items
 * 2. Filter items by low stock
 * 3. Filter items by category
 * 4. Compute total stock value for each category
 * =========================================================
 */

// ---------------------------------------------------------
// Data Class Definition
// ---------------------------------------------------------

data class Item(
    val name: String,
    val category: String,
    val stock: Int,
    val price: Double
)

// ---------------------------------------------------------
// Generic Function to Print Any List
// ---------------------------------------------------------

fun <T> printList(title: String, items: List<T>) {

    println("\n====================================")
    println(title)
    println("====================================")

    if (items.isEmpty()) {
        println("No items found.")
        return
    }

    items.forEach { println(it) }
}

// ---------------------------------------------------------
// Function to Filter Items with Low Stock
// ---------------------------------------------------------

fun filterLowStock(items: List<Item>, threshold: Int): List<Item> {
    return items.filter { it.stock <= threshold }
}

// ---------------------------------------------------------
// Function to Filter Items by Category
// ---------------------------------------------------------

fun filterByCategory(items: List<Item>, category: String): List<Item> {
    return items.filter { it.category.equals(category, ignoreCase = true) }
}

// ---------------------------------------------------------
// Function to Calculate Total Inventory Value per Category
// ---------------------------------------------------------

fun calculateCategoryTotals(items: List<Item>): Map<String, Double> {

    val totals = mutableMapOf<String, Double>()

    for (item in items) {

        val totalValue = item.stock * item.price

        totals[item.category] =
            totals.getOrDefault(item.category, 0.0) + totalValue
    }

    return totals
}

// ---------------------------------------------------------
// Main Program
// ---------------------------------------------------------

fun main() {

    println("====================================")
    println("      Inventory Management System   ")
    println("====================================")

    // List of inventory items
    val inventory = listOf(
        Item("Laptop", "Electronics", 5, 70000.0),
        Item("Smartphone", "Electronics", 10, 30000.0),
        Item("Desk Chair", "Furniture", 3, 5000.0),
        Item("Notebook", "Stationery", 20, 50.0),
        Item("Pen", "Stationery", 50, 10.0),
        Item("Table", "Furniture", 2, 12000.0)
    )

    // -----------------------------------------------------
    // Display all inventory items
    // -----------------------------------------------------

    printList("All Inventory Items", inventory)

    // -----------------------------------------------------
    // Filter items with low stock
    // -----------------------------------------------------

    val lowStockItems = filterLowStock(inventory, 5)
    printList("Low Stock Items (Stock <= 5)", lowStockItems)

    // -----------------------------------------------------
    // Filter items by category
    // -----------------------------------------------------

    val electronicsItems = filterByCategory(inventory, "Electronics")
    printList("Electronics Category Items", electronicsItems)

    // -----------------------------------------------------
    // Calculate category totals
    // -----------------------------------------------------

    val categoryTotals = calculateCategoryTotals(inventory)

    println("\n====================================")
    println("Inventory Value by Category")
    println("====================================")

    for ((category, totalValue) in categoryTotals) {
        println("$category : ₹$totalValue")
    }

    println("\nProgram Finished Successfully.")
}