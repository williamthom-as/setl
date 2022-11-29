package as.williamthom.setl

import as.williamthom.setl.dsl.SourceDslBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DslBuilderTest {

    @Test
    @DisplayName("Valid source profile should load")
    void loadsSource() {
        def inputStream = DslBuilderTest.getResourceAsStream("/TestConfig.groovy")
        def output = new DslParser().parse(inputStream)

//        Assertions.assertEquals(SourceDslBuilder.FileType.CSV, output.sourceBuilder.fileType, "Should return CSV file type")
        Assertions.assertEquals(1, output.sourceBuilder.content.sections.size(), "Should return two section")
    }
}
