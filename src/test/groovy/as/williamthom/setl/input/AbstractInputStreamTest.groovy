package as.williamthom.setl.input

import as.williamthom.setl.dsl.DslParser
import as.williamthom.setl.input.impl.csv.CSVInputStream
import as.williamthom.setl.output.impl.csv.CSVOutputStream
import as.williamthom.setl.stream.StreamThreadManager
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class AbstractInputStreamTest {

    @Test
    @DisplayName("Valid CSV source profile should load")
    void loadsCSVSource() {
        def is = AbstractInputStreamTest.getResourceAsStream("/TestCSVConfig.groovy")
        def parse = new DslParser().parse(is)

        CSVInputStream inputStream = parse.inputBuilder.streamType.stream as CSVInputStream
        CSVOutputStream outputStream = parse.outputBuilder.streamType.stream as CSVOutputStream

        def threadManager = new StreamThreadManager(inputStream, outputStream)
        threadManager.initialize()
        threadManager.start()
        threadManager.finish()
    }

}
