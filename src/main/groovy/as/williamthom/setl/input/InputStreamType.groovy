package as.williamthom.setl.input


import as.williamthom.setl.input.impl.csv.CSVInputStream
import as.williamthom.setl.input.impl.json.JSONInputStream

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