package as.williamthom.setl.input.impl.json

import as.williamthom.setl.stream.AbstractStreamParams

class JSONInputStreamParams extends AbstractStreamParams {
    String filepath
    String listpath

    Integer chunk

    JSONInputStreamParams filepath(String filepath) {
        this.filepath = filepath
        return this
    }

    // This is a bit limiting because if we have a child array, in order
    // to access it, we need to stream the parent in, which loads the whole
    // object into memory.
    //
    // Where possible, we should operate on KV pairs only
    JSONInputStreamParams listpath(String listpath) {
        this.listpath = listpath
        return this
    }

    JSONInputStreamParams chunk(Integer chunk) {
        this.chunk = chunk
        return this
    }
}