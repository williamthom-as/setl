package as.williamthom.setl.input.impl.csv

import as.williamthom.setl.stream.AbstractStreamParams

class CSVInputStreamParams extends AbstractStreamParams {
    String filepath
    Integer chunk

    Integer headerRow = 0

    CSVInputStreamParams filepath(String filepath) {
        this.filepath = filepath
        return this
    }

    CSVInputStreamParams chunk(Integer chunk) {
        this.chunk = chunk
        return this
    }

    CSVInputStreamParams headers(Integer rowIdx) {
        this.headerRow = rowIdx
        return this
    }

}