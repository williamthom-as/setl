package as.williamthom.setl.input

class RowRecord {
    Map<String, Object> content

    RowRecord(Map<String, Object> content) {
        this.content = content
    }

    List<String> getRowKeys() {
        return this.content.keySet()
    }

    List<Object> getRowObjects() {
        return this.content.values()
    }
}
