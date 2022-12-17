package as.williamthom.setl.output

import groovy.util.logging.Slf4j

import java.lang.reflect.ParameterizedType

@Slf4j
abstract class AbstractOutputStream<T extends AbstractOutputStreamParams> {

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

    abstract void output()

}

