package as.williamthom.setl.stream

class OutputStreamBuilder {

    StreamType streamType

    void type(StreamType streamType, final Closure closure) {
        this.streamType = streamType
        this.streamType.setImplParams(closure)
    }

    // Supported stream types
    final StreamType csv = StreamType.CSV
}