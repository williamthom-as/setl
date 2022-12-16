package as.williamthom.setl.common

import com.opencsv.CSVReaderBuilder

trait CSVHelpers implements FileSystemHelpers {

    <T> T withCSVReader(String filepath, Integer skipLines, CSVReaderConsumer consumer) {
        withFileAsInputStream(filepath) { InputStream is ->
            CSVReaderBuilder readerBuilder = new CSVReaderBuilder(new InputStreamReader(is))
            if (skipLines && skipLines > 0) {
                readerBuilder.withSkipLines(skipLines)
            }

            consumer.consume(readerBuilder.build())
        } as T
    }

}
