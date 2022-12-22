package as.williamthom.setl.transform

import as.williamthom.setl.transform.action.Action
import as.williamthom.setl.transform.action.CapitalizeAction

class ExtractorBuilder {
    String propertyName
    String targetColumn
    List<Action> actions = []

    ExtractorBuilder to(String targetColumn) {
        this.targetColumn = targetColumn
        return this
    }

    ExtractorBuilder capitalize() {
        actions << new CapitalizeAction()
        return this
    }

    ExtractorBuilder extract(String type) {
        return this
    }

    ExtractorDescriptor build() {
//        return new ExtractorDescriptor(colIndex: colIndex, targetColumn: targetColumn, transforms: transforms)
    }

}
