package as.williamthom.setl

import as.williamthom.setl.inputstream.InputStreamBuilder
import as.williamthom.setl.outputstream.OutputStreamBuilder

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



