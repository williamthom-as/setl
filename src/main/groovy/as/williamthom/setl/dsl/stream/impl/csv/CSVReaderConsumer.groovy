package as.williamthom.setl.dsl.stream.impl.csv

import com.opencsv.CSVReader

interface CSVReaderConsumer<T> {
    T consume(CSVReader reader)
}