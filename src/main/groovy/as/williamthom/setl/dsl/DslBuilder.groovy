package as.williamthom.setl.dsl

import as.williamthom.setl.dsl.stream.AbstractStreamImpl
import as.williamthom.setl.dsl.stream.CSVStreamImpl

class DslBuilder {

    InputBuilder inputBuilder

    void input(@DelegatesTo(value = InputBuilder, strategy = Closure.DELEGATE_ONLY) final Closure closure) {
        this.inputBuilder = new InputBuilder()

        closure.delegate = inputBuilder
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()

        this.inputBuilder.streamType.description()
    }
}

class InputBuilder {

    StreamType streamType

    void type(String streamType, final Closure closure) {
        this.streamType = StreamType.valueOf(streamType)
        this.streamType.setImplParams(closure)
    }

}

enum StreamType {
    CSV(CSVStreamImpl)

    AbstractStreamImpl stream

    StreamType(Class<? extends AbstractStreamImpl> stream) {
        this.stream = stream.getDeclaredConstructor().newInstance()
    }

    void setImplParams(final Closure closure) {
        stream.setImplParams(closure)
    }

    void description() {
        this.stream.description()
    }
}