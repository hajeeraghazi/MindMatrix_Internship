// -----------------
// Student Solution
// -----------------

// Data class
data class Profile(val name: String, val title: String, val bio: String)

// Render ASCII Avatar
fun renderAvatar(width: Int, height: Int): String {
    val sb = StringBuilder()
    val horizontalBorder = "+" + "-".repeat(width) + "+\n"

    sb.append(horizontalBorder)

    for (i in 0 until height) {
        val content = if (i == height / 2) {
            val text = "Avatar"
            val padding = (width - text.length) / 2
            " ".repeat(padding) + text + " ".repeat(width - padding - text.length)
        } else {
            " ".repeat(width)
        }
        sb.append("|$content|\n")
    }

    sb.append(horizontalBorder)
    return sb.toString()
}

// Render Text Block
fun renderTextBlock(label: String, text: String, width: Int): String {
    val content = "$label: $text"
    val trimmed = if (content.length > width) {
        content.take(width)
    } else {
        content + " ".repeat(width - content.length)
    }
    return "|$trimmed|\n"
}

// Render Full Profile Card
fun renderProfile(
    profile: Profile,
    width: Int = 30,
    showAvatar: Boolean = true
): String {
    val sb = StringBuilder()
    val border = "+" + "-".repeat(width) + "+\n"

    sb.append(border)

    if (showAvatar) {
        val avatar = renderAvatar(width, 3)
            .lines()
            .drop(1)
            .dropLast(1)
        avatar.forEach { sb.append(it).append("\n") }
    }

    sb.append(renderTextBlock("Name", profile.name, width))
    sb.append(renderTextBlock("Title", profile.title, width))
    sb.append(renderTextBlock("Bio", profile.bio, width))

    sb.append(border)
    return sb.toString()
}

// Main function
fun main() {

    val profile1 = Profile(
        "Ada Lovelace",
        "Software Dev",
        "Early computing pioneer"
    )

    val profile2 = Profile(
        "Alan Turing",
        "Mathematician",
        "Father of AI"
    )

    val profile3 = Profile(
        "Grace Hopper",
        "Computer Scientist",
        "Developed COBOL"
    )

    println(renderProfile(profile1, 30, true))
    println(renderProfile(profile2, 30, false))
    println(renderProfile(profile3, 30, true))
}
