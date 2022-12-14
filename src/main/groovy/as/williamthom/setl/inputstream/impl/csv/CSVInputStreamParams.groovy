package as.williamthom.setl.inputstream.impl.csv

import as.williamthom.setl.inputstream.impl.AbstractInputStreamParams

class CSVInputStreamParams extends AbstractInputStreamParams {
    String filepath
    Integer headerRow

    CSVInputStreamParams filepath(String filepath) {
        this.filepath = filepath
        return this
    }

    CSVInputStreamParams headers(Integer rowIdx) {
        this.headerRow = rowIdx
        return this
    }
}