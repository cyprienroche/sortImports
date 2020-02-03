import java.io.File

fun main(args: Array<String>) {
    val fileName = args[0]
    val imps = fileToList(fileName).sorted()
    printBackToFile(fileName, imps)
}

const val delimiter = "import "

fun fileToList(fileName: String): List<String>
        = File(fileName).readLines()

fun getImport(imp: String): String = imp.split(delimiter)[1]

fun List<String>.sortImports(): List<String> = this.sorted()

fun printBackToFile(fileName: String, imps: List<String>): Unit = File(fileName).writeText(imps.reduce { a, b -> a + "\n" + b})
