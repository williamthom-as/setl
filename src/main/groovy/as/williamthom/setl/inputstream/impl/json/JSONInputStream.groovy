package as.williamthom.setl.inputstream.impl.json

import as.williamthom.setl.inputstream.ChunkedRowConsumer
import as.williamthom.setl.inputstream.impl.AbstractInputStream

class JSONInputStream extends AbstractInputStream<JSONInputStreamParams> {

    @Override
    void description() {
        println "JSON stream configured with ${params.filepath}"
    }

    @Override
    void process(ChunkedRowConsumer consumer) {}
}