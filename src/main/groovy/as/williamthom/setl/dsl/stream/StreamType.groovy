package as.williamthom.setl.dsl.stream

import as.williamthom.setl.dsl.stream.impl.AbstractStreamImpl
import as.williamthom.setl.dsl.stream.impl.CSVStreamImpl

enum StreamType {
    CSV(CSVStreamImpl)

    AbstractStreamImpl stream

    StreamType(Class<? extends AbstractStreamImpl> stream) {
        this.stream = stream.getDeclaredConstructor().newInstance()
    }

    void setImplParams(final Closure closure) {
        stream.setImplParams(closure)
    }
}