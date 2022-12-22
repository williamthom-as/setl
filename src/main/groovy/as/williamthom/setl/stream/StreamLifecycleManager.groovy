package as.williamthom.setl.stream

class StreamLifecycleManager {

    static <T> T handle(AbstractStream stream, StreamConsumer<T> streamConsumer) {
        try {
            stream.setup()
            stream.start() // Thread.start()

            streamConsumer.consume(stream)
        } finally {
//            stream.finish()
        }
    }

}

interface StreamConsumer<T> {
    T consume(AbstractStream stream)
}