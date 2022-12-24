package as.williamthom.setl.transform

import as.williamthom.setl.transform.action.Action
import as.williamthom.setl.transform.action.CapitalizeAction
import as.williamthom.setl.transform.action.LowerCaseAction
import as.williamthom.setl.transform.action.ShortenAction
import as.williamthom.setl.transform.extract.AbstractExtractType

class ExtractorBuilder {
    String propertyName
    String targetColumn
    ExtractType extract
    List<Action> actions = []

    ExtractorBuilder extract(ExtractType type, Map params = [:]) {
        type.setParams(params)
        this.extract = type

        return this
    }

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

    ExtractorDescriptor build() {
//        return new ExtractorDescriptor(colIndex: colIndex, targetColumn: targetColumn, transforms: transforms)
    }

}
