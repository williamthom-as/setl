package as.williamthom.setl.dsl

import as.williamthom.setl.dsl.content.ContentBuilder
import as.williamthom.setl.dsl.stream.StreamBuilder

class SourceDslBuilder {

    final Map<String, String> variables = [:]

    ContentBuilder content
    StreamBuilder stream

    void stream(@DelegatesTo(value = StreamBuilder, strategy = Closure.DELEGATE_FIRST) final Closure closure) {
        stream = new StreamBuilder()
        closure.delegate = stream
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

    void variables(@DelegatesTo(value = Map, strategy = Closure.DELEGATE_FIRST) final Closure closure) {
        this.variables.with(closure)
    }

    void content(@DelegatesTo(value = ContentBuilder, strategy = Closure.DELEGATE_ONLY) final Closure closure) {
        content = new ContentBuilder()
        closure.delegate = content
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()

        content.sections.each {it.init() }
    }


}


