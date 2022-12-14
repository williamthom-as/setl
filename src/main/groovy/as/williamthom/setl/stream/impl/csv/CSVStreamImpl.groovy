package as.williamthom.setl.stream.impl.csv

import as.williamthom.setl.common.FileSystemHelpers
import as.williamthom.setl.stream.RowConsumer
import as.williamthom.setl.stream.impl.AbstractStreamImpl
import com.opencsv.CSVReader
import com.opencsv.CSVReaderBuilder
import groovy.util.logging.Slf4j

@Slf4j
class CSVStreamImpl extends AbstractStreamImpl<CSVStreamImplParams> implements FileSystemHelpers {

    @Override
    void description() {
        log.info "CSV stream configured with ${params.filepath}"
    }

    @Override
    void process(RowConsumer consumer) {
        log.info "Preparing CSV to stream from ${params.filepath}"

        withCSVReader() { CSVReader reader ->
            // Because we skip lines, we know headers will always be at 0
            String[] headers = reader.readNext()
            String[] row
            while ((row = reader.readNext()) != null) {
                Map<String, String> rowValues = new HashMap<>()

                headers.eachWithIndex { String entry, int i ->
                    rowValues.put(entry, row[i])
                }

                consumer.consume(rowValues)
            }
        }
    }

    <T> T withCSVReader(CSVReaderConsumer consumer) {
        withFileAsInputStream(params.filepath) { InputStream is ->
            CSVReaderBuilder readerBuilder = new CSVReaderBuilder(new InputStreamReader(is))
            if (params.headerRow && params.headerRow > 0) {
                readerBuilder.withSkipLines(params.headerRow)
            }

            consumer.consume(readerBuilder.build())
        } as T
    }
}

