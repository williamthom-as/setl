package as.williamthom.setl.stream.impl.csv

import as.williamthom.setl.stream.impl.AbstractStreamImplParams

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