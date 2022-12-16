package as.williamthom.setl.input.impl.json

import as.williamthom.setl.common.JSONHelpers
import as.williamthom.setl.input.ChunkedRowConsumer
import as.williamthom.setl.input.impl.AbstractInputStream
import com.fasterxml.jackson.core.TreeNode
import com.fasterxml.jackson.databind.ObjectMapper
import groovy.util.logging.Slf4j


@Slf4j
class JSONInputStream extends AbstractInputStream<JSONInputStreamParams> implements JSONHelpers {

    @Override
    void description() {
        log.info "JSON stream configured with ${params.filepath}"
    }

    @Override
    void process(ChunkedRowConsumer consumer) {
        log.info "Preparing JSON stream from ${params.filepath}"
        ObjectMapper mapper = new ObjectMapper()
        List<Map<String, String>> chunk = []

        Integer defaultChunkSize = params.chunk ?: DEFAULT_CHUNK_SIZE

        withJSONParser(params.filepath) { TreeNode record ->
            Map<String, Object> mapValues = mapper.convertValue(record, HashMap.class);
            chunk << mapValues

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

