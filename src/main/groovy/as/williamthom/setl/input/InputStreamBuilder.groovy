package as.williamthom.setl.input

class InputStreamBuilder {

    InputStreamType streamType

    void type(InputStreamType streamType, final Closure closure) {
        this.streamType = streamType
        this.streamType.setImplParams(closure)
    }

    // Supported stream types
    // D1: How can we avoid having to specify here?
    final InputStreamType csv = InputStreamType.CSV
    final InputStreamType json = InputStreamType.JSON
}