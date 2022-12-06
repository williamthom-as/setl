package as.williamthom.setl.dsl.stream

class InputStreamBuilder {

    StreamType streamType

    void type(StreamType streamType, final Closure closure) {
        this.streamType = streamType
        this.streamType.setImplParams(closure)
    }

    // Supported stream types
    final StreamType csv = StreamType.CSV
}