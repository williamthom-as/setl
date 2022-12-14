package as.williamthom.setl

import as.williamthom.setl.input.InputStreamType
import as.williamthom.setl.input.impl.csv.CSVInputStreamParams
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DslBuilderTest {

    @Test
    @DisplayName("Valid source profile should load")
    void loadsSource() {
        def inputStream = DslBuilderTest.getResourceAsStream("/TestConfig.groovy")
        def output = new DslParser().parse(inputStream)

        Assertions.assertEquals(
            InputStreamType.CSV,
            output.inputBuilder.streamType,
            "Should return CSV file type"
        )

        Assertions.assertEquals(
            "src/test/resources/unsectioned_csv.csv",
            (output.inputBuilder.streamType.stream.params as CSVInputStreamParams).filepath ,
            "Should return CSV file location"
        )
    }

    @Test
    void process() {
        def inputStream = DslBuilderTest.getResourceAsStream("/TestConfig.groovy")
        def output = new DslParser().parse(inputStream)

        int lineCount = 0
        output.inputBuilder.streamType.stream.process {
            lineCount += it.size()
        }

        Assertions.assertEquals(lineCount, 8, "Should return all files from chunks")
    }

}
