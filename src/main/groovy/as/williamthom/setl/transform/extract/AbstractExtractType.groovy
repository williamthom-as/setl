package as.williamthom.setl.transform.extract

abstract class AbstractExtractType {
    protected Map params

    void setParams(Map params) {
        this.params = params
    }
}

class AllExtractType extends AbstractExtractType {

}

class RegexExtractType extends AbstractExtractType {

}