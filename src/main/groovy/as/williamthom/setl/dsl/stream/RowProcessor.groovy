package as.williamthom.setl.dsl.stream

interface RowProcessor {

    void processRow(int rowIdx, Map<String,Object> row)

}
