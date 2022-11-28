package as.williamthom.setl.dsl

import as.williamthom.setl.dsl.content.ContentBuilder

class SourceDslBuilder {

    FileType fileType
    String location

    final Map<String, String> variables = [:]

    ContentBuilder content

    void stream(FileType fileType, String location) {
        this.fileType = fileType
        this.location = location
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

    final FileType csv = FileType.CSV

    enum FileType {
        CSV
    }
}