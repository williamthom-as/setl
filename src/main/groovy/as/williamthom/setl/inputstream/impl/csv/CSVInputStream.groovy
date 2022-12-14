package as.williamthom.setl.inputstream.impl.csv

import as.williamthom.setl.common.FileSystemHelpers
import as.williamthom.setl.inputstream.ChunkedRowConsumer
import as.williamthom.setl.inputstream.impl.AbstractInputStream
import com.opencsv.CSVReader
import com.opencsv.CSVReaderBuilder
import groovy.util.logging.Slf4j

@Slf4j
class CSVInputStream extends AbstractInputStream<CSVInputStreamParams> implements FileSystemHelpers {

    private static final int CHUNK_SIZE = 3

    @Override
    void description() {
        log.info "CSV stream configured with ${params.filepath}"
    }

    @Override
    void process(ChunkedRowConsumer consumer) {
        log.info "Preparing CSV to stream from ${params.filepath}"

        withCSVReader() { CSVReader reader ->
            // Because we skip lines, we know headers will always be at 0
            String[] headers = reader.readNext()
            String[] row

            List<Map<String, String>> chunk = []

            while ((row = reader.readNext()) != null) {
                Map<String, String> rowValues = new HashMap<>()
                headers.eachWithIndex { String entry, int i ->
                    rowValues.put(entry, row[i])
                }

                chunk << rowValues

                if (chunk.size() == CHUNK_SIZE) {
                    consumer.consume(chunk)
                    chunk = []
                }
            }

            if (chunk.size() > 0) {
                consumer.consume(chunk)
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

