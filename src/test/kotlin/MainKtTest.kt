import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class MainKtTest {

    @Test
    fun canSortBasic() {
        val imp = listOf("a", "aa", "ab", "b", "bb")
        assertThat(sortImports(imp), `is`(imp))
    }

    @Test
    fun canSortComplex() {
        val exp = listOf(
            "wacc.antlr.WaccParser",
            "wacc.antlr.WaccParser.ArrayTypeContext",
            "wacc.antlr.WaccParser.BaseTypeContext",
            "wacc.antlr.WaccParser.PairElemTypeContext",
            "wacc.antlr.WaccParser.PairTypeContext",
            "wacc.antlr.WaccParserBaseVisitor",
            "wacc.ast.ArrayT",
            "wacc.ast.GenericPairT"
        )
        assertThat(sortImports(exp.shuffled()), `is`(exp))
    }

    @Test
    fun canGetImportNameGivenString() {
        assertThat(getImport("import A"), `is`("A"))
        assertThat(getImport("import wacc.antlr.WaccParser"), `is`("wacc.antlr.WaccParser"))
    }
}