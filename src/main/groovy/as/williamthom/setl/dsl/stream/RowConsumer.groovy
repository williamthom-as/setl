package as.williamthom.setl.dsl.stream

interface RowConsumer<T> {
    T consume(Map<String, String> rowValues)
}