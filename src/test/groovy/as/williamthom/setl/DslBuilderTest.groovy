package as.williamthom.setl

import as.williamthom.setl.dsl.stream.InputStreamBuilder
import as.williamthom.setl.dsl.stream.StreamType
import as.williamthom.setl.dsl.stream.impl.csv.CSVStreamImplParams
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
            StreamType.CSV,
            output.inputBuilder.streamType,
            "Should return CSV file type"
        )

//        Assertions.assertEquals(
//            "some_file",
//            (output.inputBuilder.streamType.stream.params as CSVStreamImplParams).filepath ,
//            "Should return CSV file location"
//        )

        output.inputBuilder.streamType.stream.process {
//            println it
        }
    }

    @Test
    void test1() {
        def inputBuilder = new InputStreamBuilder()
        inputBuilder.type(StreamType.CSV) {
            filepath "test"
        }

        inputBuilder.streamType.stream.description()
    }
}
