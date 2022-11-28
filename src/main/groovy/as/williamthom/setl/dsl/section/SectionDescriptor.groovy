package as.williamthom.setl.dsl.section

import as.williamthom.setl.dsl.workflow.WorkflowBuilder

class SectionDescriptor {

    Integer headerRowIdx

    WorkflowBuilder workflow

    void headers(int headerRowIdx) {
        this.headerRowIdx = headerRowIdx
    }

    void workflow(final Closure closure) {
        workflow = new WorkflowBuilder()
        closure.delegate = workflow
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()

        workflow.stages.each { it.init() }
    }
}



