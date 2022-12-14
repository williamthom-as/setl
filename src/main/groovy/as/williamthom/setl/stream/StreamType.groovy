package as.williamthom.setl.stream

import as.williamthom.setl.stream.impl.AbstractStreamImpl
import as.williamthom.setl.stream.impl.csv.CSVStreamImpl
import as.williamthom.setl.stream.impl.json.JSONStreamImpl

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