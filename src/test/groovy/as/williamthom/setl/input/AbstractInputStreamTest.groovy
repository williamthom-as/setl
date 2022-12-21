package as.williamthom.setl.input

import as.williamthom.setl.dsl.DslParser
import as.williamthom.setl.input.impl.csv.CSVInputStream
import as.williamthom.setl.output.impl.csv.CSVOutputStream
import as.williamthom.setl.stream.AbstractStream
import as.williamthom.setl.stream.StreamLifecycleManager
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import java.util.concurrent.CountDownLatch
import java.util.concurrent.LinkedBlockingQueue

class AbstractInputStreamTest {

    @Test
    @DisplayName("Valid CSV source profile should load")
    void loadsCSVSource() {
        def is = AbstractInputStreamTest.getResourceAsStream("/TestCSVConfig.groovy")
        def parse = new DslParser().parse(is)

        CSVInputStream inputStream = parse.inputBuilder.streamType.stream as CSVInputStream
        CSVOutputStream outputStream = parse.outputBuilder.streamType.stream as CSVOutputStream

        CountDownLatch latch = new CountDownLatch(2)
        LinkedBlockingQueue<List<RowRecord>> queue = new LinkedBlockingQueue<List<RowRecord>>(100)

        inputStream.initialize(queue, latch)
        outputStream.initialize(queue, latch)

        StreamLifecycleManager.handle(inputStream) { AbstractStream stream ->
//            stream.join(50)
            latch.countDown()
        }

//        sleep(50)

        StreamLifecycleManager.handle(outputStream) { AbstractStream stream ->
//            stream.join()
            latch.countDown()
        }

//        outputStream.start()

        inputStream.join()
        outputStream.join()

//        while (!queue.isEmpty()) {
//            outputStream.close()
//        }

//        int lineCount = 0
//        while (!queue.isEmpty()) {
//            lineCount += queue.take().size()
//        }
//        Assertions.assertEquals(lineCount, 8, "Returns all files from chunks that have been queued")

    }

}
