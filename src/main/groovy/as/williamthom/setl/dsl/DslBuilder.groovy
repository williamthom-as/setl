package as.williamthom.setl.dsl

import as.williamthom.setl.input.InputStreamBuilder
import as.williamthom.setl.output.OutputStreamBuilder
import as.williamthom.setl.transform.TransformBuilder

class DslBuilder {

    InputStreamBuilder inputBuilder
    OutputStreamBuilder outputBuilder
    TransformBuilder transformBuilder

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

    void transform(@DelegatesTo(value = TransformBuilder, strategy = Closure.DELEGATE_ONLY) final Closure closure) {
        this.transformBuilder = new TransformBuilder()

        closure.delegate = transformBuilder
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }
}



