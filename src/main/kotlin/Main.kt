import java.io.File

fun main(args: Array<String>) {
    val file = File(args[0])
    file.writeText(file.readLines().sorted().reduce { a, b -> a + "\n" + b})
}