package as.williamthom.setl.transform

class TransformBuilder {

    private List<ExtractorBuilder> extractorBuilders = []

    ExtractorBuilder identity(String propertyName) {
        def builder = new ExtractorBuilder(propertyName: propertyName)
        extractorBuilders << builder

        return builder
    }

    List<ExtractorDescriptor> build() {
        extractorBuilders.collect {
            it.build()
        }
    }

    final ExtractType all = ExtractType.All
    final ExtractType regex = ExtractType.Regex

}
