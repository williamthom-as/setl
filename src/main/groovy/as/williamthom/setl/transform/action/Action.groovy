package as.williamthom.setl.transform.action

interface Action {
    Object transform(Object source)

}

class CapitalizeAction implements Action {

    @Override
    Object transform(Object source) {
        return null
    }
}