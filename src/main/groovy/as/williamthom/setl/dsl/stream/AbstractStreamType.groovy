package as.williamthom.setl.dsl.stream

import java.lang.reflect.ParameterizedType

abstract class AbstractStreamType<T extends AbstractStreamTypeParams> {

    private T params

    Class<T> getParamsClass() {
        return ((Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0])
    }

}