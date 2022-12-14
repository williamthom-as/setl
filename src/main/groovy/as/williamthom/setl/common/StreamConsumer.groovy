package as.williamthom.setl.common

interface StreamConsumer<T> {
    T consume(InputStream stream)
}