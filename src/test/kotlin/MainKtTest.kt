import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class MainKtTest {

    private val listOfImports = listOf(
        "wacc.antlr.WaccParser",
        "wacc.antlr.WaccParser.ArrayTypeContext",
        "wacc.antlr.WaccParser.BaseTypeContext",
        "wacc.antlr.WaccParser.PairElemTypeContext",
        "wacc.antlr.WaccParser.PairTypeContext",
        "wacc.antlr.WaccParserBaseVisitor",
        "wacc.ast.ArrayT",
        "wacc.ast.GenericPairT"
    )

    @Test
    fun canSortBasic() {
        val imp = listOf("a", "aa", "ab", "b", "bb")
        assertThat(imp.sortImports(), `is`(imp))
    }

    @Test
    fun canSortComplex() {

        assertThat(listOfImports.shuffled().sortImports(), `is`(listOfImports))
    }

    @Test
    fun canGetImportNameGivenString() {
        assertThat(getImport("import A"), `is`("A"))
        assertThat(getImport("import wacc.antlr.WaccParser"), `is`("wacc.antlr.WaccParser"))
    }

    @Test
    fun canGetListFromFile() {
        assertThat(fileToList("src/test/resources/example.txt").map { getImport(it) }, `is`(listOfImports))
    }
}