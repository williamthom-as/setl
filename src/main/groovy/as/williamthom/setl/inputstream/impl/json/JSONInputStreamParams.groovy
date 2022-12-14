package as.williamthom.setl.inputstream.impl.json

import as.williamthom.setl.inputstream.impl.AbstractInputStreamParams

class JSONInputStreamParams extends AbstractInputStreamParams {
    String filepath

    JSONInputStreamParams filepath(String filepath) {
        this.filepath = filepath
        return this
    }
}