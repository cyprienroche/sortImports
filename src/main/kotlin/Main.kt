fun main() {
    val s = "import a"
    println(getImport(s))
}

const val delimiter = "import "

fun getImport(imp: String): String = imp.split(delimiter)[1]

fun sortImports(im: List<String>): List<String> = im.sorted()
