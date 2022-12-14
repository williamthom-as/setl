package as.williamthom.setl.stream.impl.json

import as.williamthom.setl.stream.impl.AbstractStreamImplParams

class JSONStreamImplParams extends AbstractStreamImplParams {
    String filepath

    JSONStreamImplParams filepath(String filepath) {
        this.filepath = filepath
        return this
    }
}