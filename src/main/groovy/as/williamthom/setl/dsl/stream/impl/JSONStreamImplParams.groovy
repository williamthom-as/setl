package as.williamthom.setl.dsl.stream.impl

class JSONStreamImplParams extends AbstractStreamImplParams {
    String filepath

    JSONStreamImplParams filepath(String filepath) {
        this.filepath = filepath
        return this
    }
}