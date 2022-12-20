package as.williamthom.setl.output

import as.williamthom.setl.output.impl.console.ConsoleOutputStream
import as.williamthom.setl.output.impl.csv.CSVOutputStream

enum OutputStreamType {
    CSV(CSVOutputStream),
    Console(ConsoleOutputStream)

    AbstractOutputStream stream

    OutputStreamType(Class<? extends AbstractOutputStream> stream) {
        this.stream = stream.getDeclaredConstructor().newInstance()
    }

    void setImplParams(final Closure closure) {
        stream.setImplParams(closure)
    }
}