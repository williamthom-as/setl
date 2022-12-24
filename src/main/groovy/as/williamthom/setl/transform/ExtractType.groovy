package as.williamthom.setl.transform

import as.williamthom.setl.transform.extract.AbstractExtractType
import as.williamthom.setl.transform.extract.AllExtractType
import as.williamthom.setl.transform.extract.RegexExtractType

enum ExtractType {
    All(AllExtractType),
    Regex(RegexExtractType)

    AbstractExtractType type

    ExtractType(Class<? extends AbstractExtractType> type) {
        this.type = type.getDeclaredConstructor().newInstance()
    }

    void setParams(Map params) {
        this.type.setParams(params)
    }

}