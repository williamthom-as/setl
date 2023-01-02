package as.williamthom.setl.stream

interface StreamConsumer<T> {
    T consume(AbstractStream stream)
}