package as.williamthom.setl.dsl.common

interface StreamConsumer<T> {
    T consume(InputStream stream)
}