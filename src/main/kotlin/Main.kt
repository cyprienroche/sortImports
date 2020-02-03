import java.io.File

fun main(args: Array<String>) {
    println(args.get(0))
    val fileName = args[0]
    val imps = fileToList(fileName)
    val sortedImps = imps.map { getImport(it) }.sortImports()
    val restoredImp = sortedImps.map { restoreImport(it) }
    println(sortedImps)
    printBackToFile(fileName, restoredImp)
}

const val delimiter = "import "

fun fileToList(fileName: String): List<String>
        = File(fileName).readLines()

fun getImport(imp: String): String = imp.split(delimiter)[1]

fun List<String>.sortImports(): List<String> = this.sorted()

fun restoreImport(imp: String): String = delimiter + imp

fun printBackToFile(fileName: String, imps: List<String>): Unit = File(fileName).writeText(imps.reduce { a, b -> a + "\n" + b})
