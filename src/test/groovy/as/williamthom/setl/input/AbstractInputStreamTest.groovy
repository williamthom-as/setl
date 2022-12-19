package as.williamthom.setl.input

import as.williamthom.setl.dsl.DslParser
import as.williamthom.setl.input.impl.csv.CSVInputStream
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import java.util.concurrent.LinkedBlockingQueue

class AbstractInputStreamTest {

    @Test
    @DisplayName("Valid CSV source profile should load")
    void loadsCSVSource() {
        def inputStream = AbstractInputStreamTest.getResourceAsStream("/TestCSVConfig.groovy")
        def output = new DslParser().parse(inputStream)

        LinkedBlockingQueue<List<Map<String, String>>> queue = new LinkedBlockingQueue<List<Map<String, String>>>()
        CSVInputStream stream = output.inputBuilder.streamType.stream as CSVInputStream
        stream.initialize(queue).run()

        int lineCount = 0
        while (!queue.isEmpty()) {
            lineCount += queue.take().size()
        }

        Assertions.assertEquals(lineCount, 8, "Returns all files from chunks that have been queued")
    }

}
