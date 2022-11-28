package as.williamthom.setl.dsl.workflow

import as.williamthom.setl.dsl.stage.StageBuilder

class WorkflowBuilder {
    List<StageBuilder> stages = []

    void stage(String name, final Closure closure) {
        this.stages << new StageBuilder(name, closure)
    }
}