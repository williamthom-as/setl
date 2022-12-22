package as.williamthom.setl.transform

class ExtractorBuilder {
    String propertyName
    String targetColumn
//    List<Transform> transforms = []

    ExtractorBuilder to(String targetColumn) {
        this.targetColumn = targetColumn
        return this
    }

//    ExtractorBuilder capture(String regex, String defaultValue = null) {
//        transforms << new RegexTransform(regex, defaultValue)
//        return this
//    }
//
//    ExtractorBuilder custom(Closure customExtractor) {
//        transforms << new CustomTransformer(customExtractor)
//        return this
//    }

    ExtractorDescriptor build() {
        return new ExtractorDescriptor(colIndex: colIndex, targetColumn: targetColumn, transforms: transforms)
    }

}
