package as.williamthom.setl.input.impl.csv

import as.williamthom.setl.common.CSVHelpers
import as.williamthom.setl.input.ChunkedRowConsumer
import as.williamthom.setl.input.AbstractInputStream
import as.williamthom.setl.input.RowRecord
import com.opencsv.CSVReader
import groovy.util.logging.Slf4j

@Slf4j
class CSVInputStream extends AbstractInputStream<CSVInputStreamParams> implements CSVHelpers {

    @Override
    void description() {
        log.info "CSV stream configured with ${params.filepath}"
    }

    @Override
    void process(ChunkedRowConsumer consumer) {
        log.info "Preparing CSV to stream from ${params.filepath}"

        withCSVReader(params.filepath, params.headerRow) { CSVReader reader ->
            // Because we skip lines, we know headers will always be at 0
            String[] headers = reader.readNext()
            String[] row

            Integer defaultChunkSize = params.chunk ?: DEFAULT_CHUNK_SIZE
            List<RowRecord> chunk = []

            while ((row = reader.readNext()) != null) {
                Map<String, String> rowValues = new HashMap<>()
                headers.eachWithIndex { String entry, int i ->
                    rowValues.put(entry, row[i])
                }

                chunk << new RowRecord(rowValues)

                if (chunk.size() == defaultChunkSize) {
                    consumer.consume(chunk)
                    chunk = []
                }
            }

            if (chunk.size() > 0) {
                consumer.consume(chunk)
            }
        }
    }
}

