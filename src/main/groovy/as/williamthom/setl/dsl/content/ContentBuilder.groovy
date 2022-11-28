package as.williamthom.setl.dsl.content

import as.williamthom.setl.dsl.section.SectionBuilder

class ContentBuilder {
    List<SectionBuilder> sections = []

    void section(int startIdx, int endIdx, final Closure closure) {
        this.sections << new SectionBuilder(startIdx, endIdx, closure)
    }
}