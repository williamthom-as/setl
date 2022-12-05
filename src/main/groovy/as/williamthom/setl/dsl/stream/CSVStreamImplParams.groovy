package as.williamthom.setl.dsl.stream

class CSVStreamImplParams extends AbstractStreamImplParams {
    String filepath
    Integer headerRow

    CSVStreamImplParams filepath(String filepath) {
        this.filepath = filepath
        return this
    }

    CSVStreamImplParams headers(Integer rowIdx) {
        this.headerRow = rowIdx
        return this
    }
}