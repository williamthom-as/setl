package as.williamthom.setl.dsl.stream.impl.csv

import as.williamthom.setl.dsl.stream.impl.AbstractStreamImplParams

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