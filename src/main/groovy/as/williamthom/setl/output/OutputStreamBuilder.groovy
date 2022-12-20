package as.williamthom.setl.output

class OutputStreamBuilder {

    OutputStreamType streamType

    void type(OutputStreamType streamType, final Closure closure) {
        this.streamType = streamType
        this.streamType.setImplParams(closure)
    }

    // Supported stream types
    final OutputStreamType console = OutputStreamType.Console
    final OutputStreamType csv = OutputStreamType.CSV

}