package as.williamthom.setl.dsl.stream.impl.json

import as.williamthom.setl.dsl.stream.impl.AbstractStreamImplParams

class JSONStreamImplParams extends AbstractStreamImplParams {
    String filepath

    JSONStreamImplParams filepath(String filepath) {
        this.filepath = filepath
        return this
    }
}