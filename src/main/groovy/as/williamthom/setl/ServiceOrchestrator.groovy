package as.williamthom.setl

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ServiceOrchestrator {
    ExecutorService executorService

    private static final int MAX_THREAD_COUNT = 10

    ServiceOrchestrator() {
        this.executorService = Executors.newFixedThreadPool(MAX_THREAD_COUNT)
    }

    void initialize() {
        Runnable mainTask = new Runnable() {

            @Override
            void run() {

            }
        }
//        this.process { chunkedRows ->
//            executorService.execute {
//                log.debug(chunkedRows.size().toString())
//            }
//        }
    }

}
