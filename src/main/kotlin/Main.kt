import java.io.File

fun main(args: Array<String>) {
    val fileName = args[0]
    val imps = fileToList(fileName).sorted()
    printBackToFile(fileName, imps)
}

fun fileToList(fileName: String): List<String>
        = File(fileName).readLines()

fun printBackToFile(fileName: String, imps: List<String>): Unit = File(fileName).writeText(imps.reduce { a, b -> a + "\n" + b})
