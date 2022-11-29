package as.williamthom.setl.dsl.stream

class CSVStreamTypeParams extends AbstractStreamTypeParams {
    String filepath

    void filepath(String filepath) {
        this.filepath = filepath
    }
}