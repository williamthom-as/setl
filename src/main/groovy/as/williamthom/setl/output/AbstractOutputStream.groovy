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

    AbstractOutputStream<T> initialize(
        BlockingQueue<List<RowRecord>> exportQueue,
        CountDownLatch latch
    ) {
        log.info("Initializing ${streamName} stream ...")

        this.exportQueue = exportQueue
        this.latch = latch

        setup()

        return this
    }

    void run() {
        log.debug("Run called on output stream [${streamName}]")

        try {
            latch.await()

            Integer x = 0
            while (x == 0 || !exportQueue.isEmpty()) {
                log.debug("Taking chunk off transform queue [${exportQueue.size()}]")

                x++

                List<RowRecord> chunk = exportQueue.take()
                process(chunk)
            }
        } catch (InterruptedException e) {
            log.error("Interrupt occurred in output stream", e)
        }
    }

    void close() {
        finish()
    }

    abstract protected void process(List<RowRecord> rowRecords)

}


