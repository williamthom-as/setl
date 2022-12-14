package as.williamthom.setl.inputstream

class InputStreamBuilder {

    InputStreamType streamType

    void type(InputStreamType streamType, final Closure closure) {
        this.streamType = streamType
        this.streamType.setImplParams(closure)
    }

    // Supported stream types
    final InputStreamType csv = InputStreamType.CSV
}