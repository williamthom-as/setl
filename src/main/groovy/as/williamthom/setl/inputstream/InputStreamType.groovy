package as.williamthom.setl.inputstream

import as.williamthom.setl.inputstream.impl.AbstractInputStream
import as.williamthom.setl.inputstream.impl.csv.CSVInputStream
import as.williamthom.setl.inputstream.impl.json.JSONInputStream

enum InputStreamType {
    CSV(CSVInputStream),
    JSON(JSONInputStream)

    AbstractInputStream stream

    InputStreamType(Class<? extends AbstractInputStream> stream) {
        this.stream = stream.getDeclaredConstructor().newInstance()
    }

    void setImplParams(final Closure closure) {
        stream.setImplParams(closure)
    }
}