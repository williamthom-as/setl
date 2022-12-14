package as.williamthom.setl.input

interface ChunkedRowConsumer<T> {
    T consume(List<Map<String, String>> rowValues)
}