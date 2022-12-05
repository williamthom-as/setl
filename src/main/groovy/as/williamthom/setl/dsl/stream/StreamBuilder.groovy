package as.williamthom.setl.dsl.stream

class StreamBuilder {
    FileType fileType
    Map opts = [:]

    void type(FileType fileType) {
        this.fileType = fileType
    }

//    void opts(@DelegatesTo(value = Map, strategy = Closure.DELEGATE_FIRST) final Closure closure) {
//        if (!this.fileType) {
//            throw new RuntimeException("No type declared!")
//        }
//
//        closure.delegate = fileType.typeImpl.getParamsClass().getDeclaredConstructor().newInstance()
//        closure.resolveStrategy = Closure.DELEGATE_ONLY
//        closure.call()
//    }

    final FileType csv = FileType.CSV

    enum FileType {
        CSV(CSVStreamImpl)

        AbstractStreamImpl typeImpl

        FileType(Class<? extends AbstractStreamImpl> typeImpl) {
            this.typeImpl = typeImpl.getDeclaredConstructor().newInstance()
        }

    }
}