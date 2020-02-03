import java.io.File

fun main(args: Array<String>) {
    println(args.get(0))
}

const val delimiter = "import "

fun fileToList(fileName: String): List<String>
        = File(fileName).readLines()

fun getImport(imp: String): String = imp.split(delimiter)[1]

fun sortImports(im: List<String>): List<String> = im.sorted()
