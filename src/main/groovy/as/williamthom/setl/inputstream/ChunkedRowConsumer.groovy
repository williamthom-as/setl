package as.williamthom.setl.inputstream

interface ChunkedRowConsumer<T> {
    T consume(List<Map<String, String>> rowValues)
}