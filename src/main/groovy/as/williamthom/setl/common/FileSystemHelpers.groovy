package as.williamthom.setl.common

trait FileSystemHelpers {

    static <T> T withFileAsInputStream(String path, StreamConsumer<T> consumer) {
        File file = new File(path)
        try {
            file.withInputStream { InputStream is ->
                return consumer.consume(is)
            } as T
        } finally {

        }
    }

}