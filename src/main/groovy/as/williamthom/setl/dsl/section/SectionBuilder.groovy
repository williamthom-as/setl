package as.williamthom.setl.dsl.section

class SectionBuilder {

    int startIdx
    int endIdx
    Closure closure

    SectionBuilder(int startIdx, int endIdx, final Closure closure) {
        this.startIdx = startIdx
        this.endIdx = endIdx
        this.closure = closure
    }

    void init() {
        this.closure.delegate = new SectionDescriptor()
        this.closure.resolveStrategy = Closure.DELEGATE_ONLY
        this.closure.call()
    }
}