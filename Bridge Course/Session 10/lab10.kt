/**
 * =========================================================
 * Session 10 Lab: Product Analyzer
 * =========================================================
 *
 * Objective:
 * Build a console-based program that analyzes products using
 * Kotlin collections and higher-order functions.
 *
 * Concepts Used:
 * - Data classes
 * - Lists and collection transformations
 * - Higher-order functions
 * - Lambdas
 * - Filtering and mapping
 * - Formatted output
 * =========================================================
 */

// ---------------------------------------------------------
// Data Class Definition
// ---------------------------------------------------------

data class Product(
    val name: String,
    val category: String,
    val price: Double
)

// ---------------------------------------------------------
// Function to Print Products
// ---------------------------------------------------------

fun printProducts(title: String, products: List<Product>) {

    println("\n====================================")
    println(title)
    println("====================================")

    if (products.isEmpty()) {
        println("No products found.")
        return
    }

    for (product in products) {
        println(
            "Name: ${product.name} | " +
            "Category: ${product.category} | " +
            "Price: ₹${product.price}"
        )
    }
}

// ---------------------------------------------------------
// Higher-order Function to Apply Discount
// ---------------------------------------------------------

fun applyDiscount(
    products: List<Product>,
    discountFunction: (Double) -> Double
): List<Product> {

    return products.map {
        Product(
            it.name,
            it.category,
            discountFunction(it.price)
        )
    }
}

// ---------------------------------------------------------
// Main Program
// ---------------------------------------------------------

fun main() {

    println("====================================")
    println("         Product Analyzer           ")
    println("====================================")

    val products = listOf(
        Product("Laptop", "Electronics", 70000.0),
        Product("Headphones", "Electronics", 3000.0),
        Product("Chair", "Furniture", 5000.0),
        Product("Table", "Furniture", 12000.0),
        Product("Notebook", "Stationery", 50.0),
        Product("Pen", "Stationery", 10.0)
    )

    // -----------------------------------------------------
    // Display all products
    // -----------------------------------------------------

    printProducts("All Products", products)

    // -----------------------------------------------------
    // Filter expensive products
    // -----------------------------------------------------

    val expensiveProducts = products.filter { it.price > 5000 }

    printProducts("Products Price > ₹5000", expensiveProducts)

    // -----------------------------------------------------
    // Apply discount using lambda
    // -----------------------------------------------------

    val discountedProducts = applyDiscount(products) { price ->
        price * 0.9   // 10% discount
    }

    printProducts("Products After 10% Discount", discountedProducts)

    // -----------------------------------------------------
    // Transform collection (only product names)
    // -----------------------------------------------------

    val productNames = products.map { it.name }

    println("\n====================================")
    println("Product Names List")
    println("====================================")

    for (name in productNames) {
        println(name)
    }

    println("\nAnalysis Complete.")
}