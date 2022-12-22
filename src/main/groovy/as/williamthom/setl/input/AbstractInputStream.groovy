package as.williamthom.setl.input

import as.williamthom.setl.stream.AbstractStream
import as.williamthom.setl.stream.AbstractStreamParams
import groovy.util.logging.Slf4j

import java.util.concurrent.BlockingQueue
import java.util.concurrent.CountDownLatch

@Slf4j
abstract class AbstractInputStream<T extends AbstractStreamParams> extends AbstractStream<T> {

    protected static final int DEFAULT_CHUNK_SIZE = 3

    protected BlockingQueue<List<RowRecord>> transformQueue
    protected CountDownLatch latch

    AbstractInputStream<T> initialize(
        BlockingQueue<List<RowRecord>> transformQueue,
        CountDownLatch latch
    ) {
        log.info("Initializing ${streamName} stream ...")

        this.transformQueue = transformQueue
        this.latch = latch

        setup()

        return this
    }

    void setup() {}

    void run() {
        log.debug("Run called on input stream [${streamName}]")

        try {
            latch.await()

            process { List<RowRecord> chunk ->
                log.debug("Placing chunk [${chunk.size()}] on transform queue")
                transformQueue.put(chunk)
            }
        } catch (InterruptedException e) {
            log.error("Interrupt occurred in output stream", e)
        }
    }

    abstract protected void process(ChunkedRowConsumer consumer)
}


