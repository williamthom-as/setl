package as.williamthom.setl.dsl.stage

class StageBuilder {

    String name
    Closure closure

    StageBuilder(String name, final Closure closure) {
        this.name = name
        this.closure = closure
    }

    void init() {
//        this.closure.delegate = new StageDescriptor()
//        this.closure.resolveStrategy = Closure.DELEGATE_ONLY
//        this.closure.call()
    }
}