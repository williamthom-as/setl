package as.williamthom.setl.dsl

import org.codehaus.groovy.control.CompilerConfiguration

class DslParser {

    DslBuilder parse(InputStream inputStream) {
        String contents = inputStream.text

        CompilerConfiguration compilerConfig = new CompilerConfiguration()
        compilerConfig.scriptBaseClass = DelegatingScript.class.name

        GroovyShell shell = new GroovyShell(this.class.classLoader, new Binding(), compilerConfig)
        DelegatingScript delegatingScript = shell.parse(contents) as DelegatingScript

        def importScriptDelegate = new DslBuilder()
        delegatingScript.setDelegate(importScriptDelegate)
        delegatingScript.run()

        return importScriptDelegate
    }
}
