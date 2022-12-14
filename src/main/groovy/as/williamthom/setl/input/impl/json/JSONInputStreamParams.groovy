package as.williamthom.setl.input.impl.json

import as.williamthom.setl.input.impl.AbstractInputStreamParams

class JSONInputStreamParams extends AbstractInputStreamParams {
    String filepath

    JSONInputStreamParams filepath(String filepath) {
        this.filepath = filepath
        return this
    }
}