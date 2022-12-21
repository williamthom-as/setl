package as.williamthom.setl.output

import as.williamthom.setl.input.RowRecord
import as.williamthom.setl.stream.AbstractStream
import as.williamthom.setl.stream.AbstractStreamParams
import groovy.util.logging.Slf4j

import java.util.concurrent.BlockingQueue
import java.util.concurrent.CountDownLatch

@Slf4j
abstract class AbstractOutputStream<T extends AbstractStreamParams> extends AbstractStream<T> {

    protected BlockingQueue<List<RowRecord>> exportQueue
    protected CountDownLatch latch

    AbstractOutputStream<T> initialize(BlockingQueue<List<RowRecord>> exportQueue, CountDownLatch latch) {
        log.info("Initializing ${streamName} stream ...")

        this.exportQueue = exportQueue
        this.latch = latch

        setup()

        return this
    }

    void run() {
        try {
            latch.await()

            while (!exportQueue.isEmpty()) {
                log.debug("Taking chunk off transform queue [${exportQueue.size()}]")

                List<RowRecord> chunk = exportQueue.take()
                process(chunk)
            }
        } catch (InterruptedException e) {
            log.error("Interrupt occured in output stream", e)
        }
    }

    void close() {
        finish()
    }

    abstract protected void process(List<RowRecord> rowRecords)

}


