package as.williamthom.setl.input.impl

import as.williamthom.setl.input.ChunkedRowConsumer
import as.williamthom.setl.stream.AbstractStream
import as.williamthom.setl.stream.AbstractStreamParams
import groovy.util.logging.Slf4j

import java.lang.reflect.ParameterizedType

@Slf4j
abstract class AbstractInputStream<T extends AbstractStreamParams> extends AbstractStream<T> {

    protected static final int DEFAULT_CHUNK_SIZE = 3

    abstract void process(ChunkedRowConsumer consumer)

    abstract void description()

}


