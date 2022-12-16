package as.williamthom.setl.common

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.core.TreeNode
import com.fasterxml.jackson.databind.ObjectMapper

trait JSONHelpers implements FileSystemHelpers {

    <T> T withJSONParser(String filepath, JSONConsumer consumer) {
        withFileAsInputStream(filepath) { InputStream is ->
            ObjectMapper objectMapper = new ObjectMapper()
            JsonParser jsonParser = objectMapper.createParser(is)

            JsonToken nt = jsonParser.nextToken()
            while (nt != JsonToken.START_ARRAY) {
                nt = jsonParser.nextToken()
            }

            // Iterate over the records in the array
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                TreeNode record = objectMapper.readTree(jsonParser)
                consumer.consume(record)
            }
        } as T
    }
}

