package as.williamthom.setl.stream

import as.williamthom.setl.input.AbstractInputStream
import as.williamthom.setl.input.RowRecord
import as.williamthom.setl.output.AbstractOutputStream

import java.util.concurrent.CountDownLatch
import java.util.concurrent.LinkedBlockingQueue

class StreamThreadManager {

    private AbstractInputStream inputStream
    private AbstractOutputStream outputStream

    private LinkedBlockingQueue<List<RowRecord>> queue
    private CountDownLatch latch

    StreamThreadManager(AbstractInputStream inputStream, AbstractOutputStream outputStream) {
        this.inputStream = inputStream
        this.outputStream = outputStream

        this.queue = new LinkedBlockingQueue<List<RowRecord>>(10)
        this.latch = new CountDownLatch(2)
    }

    void initialize() {
        inputStream.initialize(queue, latch)
        outputStream.initialize(queue, latch)
    }

    void start() {
        StreamLifecycleManager.handle(this.inputStream) { AbstractStream stream ->
            latch.countDown()
        }

        StreamLifecycleManager.handle(this.outputStream) { AbstractStream stream ->
            latch.countDown()
        }

        this.inputStream.join()
        this.outputStream.join()
    }

    void finish() {
        this.inputStream.finish()
        this.outputStream.finish()
    }
}
