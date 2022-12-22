package as.williamthom.setl.output.impl.csv

import as.williamthom.setl.input.RowRecord
import as.williamthom.setl.output.AbstractOutputStream
import as.williamthom.setl.output.impl.console.ConsoleOutputStreamParams
import com.opencsv.CSVWriter
import com.opencsv.CSVWriterBuilder
import groovy.util.logging.Slf4j

import java.util.concurrent.Semaphore

@Slf4j
class CSVOutputStream extends AbstractOutputStream<CSVOutputStreamParams> {

    private CSVWriter csvWriter
    private final Semaphore lock = new Semaphore(1)
    private synchronized int rowCount = 0

    @Override
    protected void setup() throws IOException {
        FileWriter fileWriter = new FileWriter(params.filepath)
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)

        this.csvWriter = new CSVWriter(bufferedWriter)
    }

    @Override
    protected void process(List<RowRecord> rowRecords) throws InterruptedException, IOException {
        log.info "Preparing CSV to write content to ${params.filepath}"

        lock.acquire()

        try {
            if (rowCount == 0) {
                log.debug("First here, set headers")

                def first = rowRecords.pop()
                csvWriter.writeNext(first.getRowKeys().toArray() as String[])

                rowCount++
            }

            log.debug("Writing lines to CSV")
            rowRecords.each { RowRecord record ->
                String[] list = record.getRowObjects().collect { it.toString() }.toArray() as String[]
                csvWriter.writeNext(list)
            }
        } finally {
            lock.release()
        }
    }

    @Override
    protected void finish() {
        log.debug("Closing off CSV file")
        this.csvWriter.close()
    }

    @Override
    String getStreamName() {
        return "CSV"
    }
}
