package as.williamthom.setl.dsl.stream.impl.json

import as.williamthom.setl.dsl.stream.RowConsumer
import as.williamthom.setl.dsl.stream.impl.AbstractStreamImpl

class JSONStreamImpl extends AbstractStreamImpl<JSONStreamImplParams> {

    @Override
    void description() {
        println "JSON stream configured with ${params.filepath}"
    }

    @Override
    void process(RowConsumer consumer) {}
}