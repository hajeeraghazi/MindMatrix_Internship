// =========================================================
// KOTLIN PROJECT LAB
// Topic: Simulating Your First Android App in Kotlin
// =========================================================

@Target(AnnotationTarget.FUNCTION)
annotation class Composable

// Simulating the MainActivity structure
class MainActivity {

    fun onCreate() {
        println("Launching Greeting Card Simulation...")

        // Calling setContent with GreetingScreen
        setContent {
            GreetingScreen("Hajeera")
        }
    }

    // Simulated setContent() method
    private fun setContent(content: () -> Unit) {
        println("Setting up the content...")
        content()
    }
}

// GreetingScreen composable
@Composable
fun GreetingScreen(name: String) {
    println("Hello $name! Welcome to your first Kotlin App!")
}

// AppTheme composable
@Composable
fun AppTheme(content: () -> Unit) {
    println("Applying GreetingCard Theme...")
    content()
}

// Preview function
fun preview() {
    println("--- Preview Mode ---")
    GreetingScreen("Android Learner")
    println("--- End of Preview ---")
}

// =========================================================
// MAIN FUNCTION – entry point for simulation
// =========================================================
fun main() {
    println("========== Simulated Android App ==========\n")

    val activity = MainActivity()
    activity.onCreate()

    println()

    // Wrapping GreetingScreen inside AppTheme
    AppTheme {
        GreetingScreen("Hajeera")
    }

    println()

    // Calling preview
    preview()

    println("\n========== End of Simulation ==========")
}
