package as.williamthom.setl

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ServiceController {
    ExecutorService executorService

    private static final int MAX_THREAD_COUNT = 10

    ServiceController() {
        this.executorService = Executors.newFixedThreadPool(MAX_THREAD_COUNT)
    }

    void initialize() {
//        this.process { chunkedRows ->
//            executorService.execute {
//                log.debug(chunkedRows.size().toString())
//            }
//        }
    }

}
