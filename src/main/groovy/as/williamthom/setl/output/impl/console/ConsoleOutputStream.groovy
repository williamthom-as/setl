package as.williamthom.setl.output.impl.console

import as.williamthom.setl.input.RowRecord
import as.williamthom.setl.output.AbstractOutputStream
import groovy.util.logging.Slf4j

@Slf4j
class ConsoleOutputStream extends AbstractOutputStream<ConsoleOutputStreamParams> {

    @Override
    protected void setup() {}

    @Override
    protected void process(List<RowRecord> rowRecords) {
        rowRecords.each { RowRecord rowRecord ->
            log.info("Logging out record - ${rowRecord.content}")
        }
    }

    @Override
    protected void finish() {}

    @Override
    String getStreamName() {
        return "Console"
    }
}
