package as.williamthom.setl.input.impl.csv

import com.opencsv.CSVReader

interface CSVReaderConsumer<T> {
    T consume(CSVReader reader)
}