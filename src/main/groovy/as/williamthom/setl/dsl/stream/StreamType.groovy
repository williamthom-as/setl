package as.williamthom.setl.dsl.stream

import as.williamthom.setl.dsl.stream.impl.AbstractStreamImpl
import as.williamthom.setl.dsl.stream.impl.CSVStreamImpl
import as.williamthom.setl.dsl.stream.impl.JSONStreamImpl

enum StreamType {
    CSV(CSVStreamImpl),
    JSON(JSONStreamImpl)

    AbstractStreamImpl stream

    StreamType(Class<? extends AbstractStreamImpl> stream) {
        this.stream = stream.getDeclaredConstructor().newInstance()
    }

    void setImplParams(final Closure closure) {
        stream.setImplParams(closure)
    }
}