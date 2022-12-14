package as.williamthom.setl.stream.impl.json

import as.williamthom.setl.stream.RowConsumer
import as.williamthom.setl.stream.impl.AbstractStreamImpl

class JSONStreamImpl extends AbstractStreamImpl<JSONStreamImplParams> {

    @Override
    void description() {
        println "JSON stream configured with ${params.filepath}"
    }

    @Override
    void process(RowConsumer consumer) {}
}