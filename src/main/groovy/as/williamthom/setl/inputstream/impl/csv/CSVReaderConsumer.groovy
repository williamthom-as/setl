package as.williamthom.setl.inputstream.impl.csv

import com.opencsv.CSVReader

interface CSVReaderConsumer<T> {
    T consume(CSVReader reader)
}