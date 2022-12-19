package as.williamthom.setl.input

interface ChunkedRowConsumer<T> {
    T consume(List<RowRecord> rowValues)
}