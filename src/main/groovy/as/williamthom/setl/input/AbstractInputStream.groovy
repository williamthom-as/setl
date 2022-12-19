package as.williamthom.setl.input

import as.williamthom.setl.stream.AbstractStream
import as.williamthom.setl.stream.AbstractStreamParams
import groovy.util.logging.Slf4j

import java.util.concurrent.BlockingQueue

@Slf4j
abstract class AbstractInputStream<T extends AbstractStreamParams> extends AbstractStream<T> implements Runnable {

    protected static final int DEFAULT_CHUNK_SIZE = 3

    protected BlockingQueue<Object> transformQueue

    AbstractInputStream<T> initialize(BlockingQueue<Object> transformQueue) {
        this.transformQueue = transformQueue
        return this
    }

    void run() {
        process { List<Map<String, String>> chunk ->
            log.debug("Placing chunk [${chunk.size()}] on transform queue")
            transformQueue.put(chunk)
        }
    }

    abstract void description()

    abstract void process(ChunkedRowConsumer consumer)
}


