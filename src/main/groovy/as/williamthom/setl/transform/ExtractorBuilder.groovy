package as.williamthom.setl.transform

import as.williamthom.setl.transform.action.Action
import as.williamthom.setl.transform.action.CapitalizeAction
import as.williamthom.setl.transform.action.LowerCaseAction
import as.williamthom.setl.transform.action.ShortenAction

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

    ExtractorBuilder lowerCase() {
        actions << new LowerCaseAction()
        return this
    }

    ExtractorBuilder shorten(int length) {
        actions << new ShortenAction()
        return this
    }

    ExtractorBuilder extract(String type) {
        return this
    }

    ExtractorDescriptor build() {
//        return new ExtractorDescriptor(colIndex: colIndex, targetColumn: targetColumn, transforms: transforms)
    }

}
