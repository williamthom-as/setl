package as.williamthom.setl.output.impl.csv

import as.williamthom.setl.stream.AbstractStreamParams

class CSVOutputStreamParams extends AbstractStreamParams {
    String filepath

    CSVOutputStreamParams filepath(String filepath) {
        this.filepath = filepath
        return this
    }
}
