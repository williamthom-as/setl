package as.williamthom.setl

import as.williamthom.setl.dsl.DslBuilder
import org.codehaus.groovy.control.CompilerConfiguration

class SourceDslParser {

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
