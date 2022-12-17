package as.williamthom.setl

import as.williamthom.setl.input.InputStreamType
import as.williamthom.setl.input.impl.csv.CSVInputStreamParams
import as.williamthom.setl.input.impl.json.JSONInputStreamParams
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DslBuilderTest {

    @Test
    @DisplayName("Valid CSV source profile should load")
    void loadsCSVSource() {
        def inputStream = DslBuilderTest.getResourceAsStream("/TestCSVConfig.groovy")
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
    @DisplayName("Valid JSON source profile should load")
    void loadsJSONSource() {
        def inputStream = DslBuilderTest.getResourceAsStream("/TestJSONConfig.groovy")
        def output = new DslParser().parse(inputStream)

        Assertions.assertEquals(
                InputStreamType.JSON,
                output.inputBuilder.streamType,
                "Should return JSON file type"
        )

        Assertions.assertEquals(
                "src/test/resources/json_test_file.json",
                (output.inputBuilder.streamType.stream.params as JSONInputStreamParams).filepath ,
                "Should return JSON file location"
        )

        int lineCount = 0
        output.inputBuilder.streamType.stream.process {
            lineCount += it.size()
        }
    }

    @Test
    void process() {
        def inputStream = DslBuilderTest.getResourceAsStream("/TestCSVConfig.groovy")
        def output = new DslParser().parse(inputStream)

        int lineCount = 0
        output.inputBuilder.streamType.stream.process {
            lineCount += it.size()
        }

        Assertions.assertEquals(lineCount, 8, "Should return all files from chunks")
    }

}
