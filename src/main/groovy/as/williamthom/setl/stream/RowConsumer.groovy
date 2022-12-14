package as.williamthom.setl.stream

interface RowConsumer<T> {
    T consume(Map<String, String> rowValues)
}