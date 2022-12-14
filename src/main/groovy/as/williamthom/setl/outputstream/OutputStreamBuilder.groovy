package as.williamthom.setl.outputstream

import as.williamthom.setl.inputstream.InputStreamType

class OutputStreamBuilder {

    InputStreamType streamType

    void type(InputStreamType streamType, final Closure closure) {
        this.streamType = streamType
        this.streamType.setImplParams(closure)
    }

    // Supported stream types
    final InputStreamType csv = InputStreamType.CSV
}