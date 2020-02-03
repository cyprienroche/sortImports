import java.io.File
import java.io.BufferedInputStream
import java.math.BigDecimal

fun main(args: Array<String>) {
    val file = File(args[0])
    val partition = file.readLines().partition { it.startsWith("import") }
    val sortedImports = partition.first.sorted() + partition.second
    file.writeText(sortedImports.reduce { a, b -> a + "\n" + b})
}