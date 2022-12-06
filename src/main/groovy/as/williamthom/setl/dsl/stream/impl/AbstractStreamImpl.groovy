package as.williamthom.setl.dsl.stream.impl

import java.lang.reflect.ParameterizedType

abstract class AbstractStreamImpl<T extends AbstractStreamImplParams> {

    T params

    Class<T> getParamsClass() {
        return ((Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0])
    }

    T setImplParams(final Closure closure) {
        this.params = getParamsClass().getDeclaredConstructor().newInstance()

        closure.delegate = this.params
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure.call()
    }

    abstract void description()

}