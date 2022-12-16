package as.williamthom.setl.common

import com.opencsv.CSVReader

interface CSVReaderConsumer<T> {
    T consume(CSVReader reader)
}