package as.williamthom.setl.dsl.stream.impl

class JSONStreamImpl extends AbstractStreamImpl<JSONStreamImplParams> {

    @Override
    void description() {
        println "JSON stream configured with ${params.filepath}"
    }
}