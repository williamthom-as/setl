package as.williamthom.setl.input

import as.williamthom.setl.stream.AbstractStream
import as.williamthom.setl.stream.AbstractStreamParams
import groovy.util.logging.Slf4j

import java.util.concurrent.BlockingQueue

@Slf4j
abstract class AbstractInputStream<T extends AbstractStreamParams> extends AbstractStream<T> {

    protected static final int DEFAULT_CHUNK_SIZE = 3

    protected BlockingQueue<List<RowRecord>> transformQueue

    AbstractInputStream<T> initialize(BlockingQueue<List<RowRecord>> transformQueue) {
        log.info("Initializing ${streamName} stream ...")

        this.transformQueue = transformQueue
        return this
    }

    void setup() {}

    void run() {
        process { List<RowRecord> chunk ->
            log.debug("Placing chunk [${chunk.size()}] on transform queue")
            transformQueue.put(chunk)
        }
    }

    abstract void description()

    abstract protected void process(ChunkedRowConsumer consumer)
}


