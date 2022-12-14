package as.williamthom.setl.output

import as.williamthom.setl.input.InputStreamType

class OutputStreamBuilder {

    InputStreamType streamType

    void type(InputStreamType streamType, final Closure closure) {
        this.streamType = streamType
        this.streamType.setImplParams(closure)
    }

    // Supported stream types
    final InputStreamType csv = InputStreamType.CSV
}