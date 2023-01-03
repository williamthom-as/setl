package as.williamthom.setl.transform

import as.williamthom.setl.input.ChunkedRowConsumer
import as.williamthom.setl.input.RowRecord
import as.williamthom.setl.stream.AbstractStream
import groovy.util.logging.Slf4j

import java.util.concurrent.BlockingQueue
import java.util.concurrent.CountDownLatch

@Slf4j
class TransformStream extends AbstractStream {

    protected static final int DEFAULT_CHUNK_SIZE = 3

    protected BlockingQueue<List<RowRecord>> transformQueue
    protected CountDownLatch latch

    TransformStream initialize(
        BlockingQueue<List<RowRecord>> transformQueue,
        CountDownLatch latch
    ) {
        log.info("Initializing ${streamName} stream ...")

        this.transformQueue = transformQueue
        this.latch = latch

        return this
    }

    @Override
    String getStreamName() {
        return "Transform stream"
    }

    @Override
    protected void setup() {

    }

    @Override
    protected void finish() {

    }

    void run() {

    }

}