package as.williamthom.setl.dsl.stream.impl

class CSVStreamImpl extends AbstractStreamImpl<CSVStreamImplParams> {

    @Override
    void description() {
        println "CSV stream configured with ${params.filepath}"
    }
}