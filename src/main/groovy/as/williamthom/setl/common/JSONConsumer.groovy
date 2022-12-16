package as.williamthom.setl.common

import com.fasterxml.jackson.core.TreeNode

interface JSONConsumer<T> {
    T consume(TreeNode record)
}