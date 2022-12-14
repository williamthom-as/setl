package as.williamthom.setl.input.impl.json

import as.williamthom.setl.input.ChunkedRowConsumer
import as.williamthom.setl.input.impl.AbstractInputStream

class JSONInputStream extends AbstractInputStream<JSONInputStreamParams> {

    @Override
    void description() {
        println "JSON stream configured with ${params.filepath}"
    }

    @Override
    void process(ChunkedRowConsumer consumer) {}
}