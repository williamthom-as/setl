package as.williamthom.setl.dsl

import as.williamthom.setl.dsl.stream.InputStreamBuilder
import as.williamthom.setl.dsl.stream.OutputStreamBuilder

class DslBuilder {

    InputStreamBuilder inputBuilder
    OutputStreamBuilder outputBuilder

    void input(@DelegatesTo(value = InputStreamBuilder, strategy = Closure.DELEGATE_ONLY) final Closure closure) {
        this.inputBuilder = new InputStreamBuilder()

        closure.delegate = inputBuilder
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

    void output(@DelegatesTo(value = OutputStreamBuilder, strategy = Closure.DELEGATE_ONLY) final Closure closure) {
        this.outputBuilder = new OutputStreamBuilder()

        closure.delegate = outputBuilder
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }
}



