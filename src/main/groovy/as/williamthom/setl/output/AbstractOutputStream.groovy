package as.williamthom.setl.output


import as.williamthom.setl.input.RowRecord
import as.williamthom.setl.stream.AbstractStream
import as.williamthom.setl.stream.AbstractStreamParams
import groovy.util.logging.Slf4j

import java.util.concurrent.BlockingQueue
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Slf4j
abstract class AbstractOutputStream<T extends AbstractStreamParams> extends AbstractStream<T> {

    private static final int NUM_THREADS = 5

    protected ExecutorService executorService

    protected BlockingQueue<List<RowRecord>> exportQueue

    AbstractOutputStream<T> initialize(BlockingQueue<List<RowRecord>> exportQueue) {
        log.info("Initializing ${streamName} stream ...")

        this.executorService = Executors.newFixedThreadPool(NUM_THREADS)
        this.exportQueue = exportQueue

        setup()

        return this
    }

    void run() {

        while (!exportQueue.isEmpty()) {
            log.debug("Taking chunk off transform queue [${exportQueue.size()}]")

            List<RowRecord> chunk = exportQueue.take()
            process(chunk)
        }

//        while (!exportQueue.isEmpty()) {
//            executorService.submit {
//                  process(chunk)
//            }
//        }

//        executorService.shutdown()
//        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)
    }

    void close() {
        finish()
    }

    abstract protected void setup()

    abstract protected void process(List<RowRecord> rowRecords)

    abstract protected void finish()

}


