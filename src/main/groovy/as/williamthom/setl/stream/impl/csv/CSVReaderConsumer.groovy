package as.williamthom.setl.stream.impl.csv

import com.opencsv.CSVReader

interface CSVReaderConsumer<T> {
    T consume(CSVReader reader)
}