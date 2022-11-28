package as.williamthom.setl.dsl

class DslBuilder {

    SourceDslBuilder sourceBuilder

    void source(@DelegatesTo(value = SourceDslBuilder, strategy = Closure.DELEGATE_ONLY) final Closure closure) {
        this.sourceBuilder = new SourceDslBuilder()

        closure.delegate = sourceBuilder
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }
}