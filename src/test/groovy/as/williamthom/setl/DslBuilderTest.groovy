package as.williamthom.setl


import as.williamthom.setl.dsl.stream.StreamType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DslBuilderTest {

    @Test
    @DisplayName("Valid source profile should load")
    void loadsSource() {
        def inputStream = DslBuilderTest.getResourceAsStream("/TestConfig.groovy")
        def output = new DslParser().parse(inputStream)

        Assertions.assertEquals(StreamType.CSV, output.inputBuilder.streamType, "Should return CSV file type")
    }

//    @Test
//    void test1() {
//        def inputBuilder = new InputBuilder()
//        inputBuilder.type("CSV") {
//            filepath "test"
//        }
//
//        inputBuilder.streamType.description()
//    }
}
