package json.parser.formatter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * A <code>JSONMinimizer</code> adds minimizing functionality to another JSON reader.
 * Specifically, it allows an input JSON string to be read
 * with all unnecessary characters omitted.
 *
 * @author Agere98
 * @version 0.1
 * @since 0.1
 */
public class JSONMinimizer extends JSONFormatter {

    /**
     * Creates a <code>JSONMinimizer</code>
     * and stores its argument, reader, for functionality extension.
     *
     * @param objectMapper the underlying JSON reader.
     */
    @Autowired
    public JSONMinimizer(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    /**
     * Reads a JSON string and returns its minimized representation.
     * All characters that have no semantic relevance according to the JSON format
     * (for example spaces, new lines) are removed from the output string.
     * Thus, the resulting string is the shortest possible representation
     * (in terms of character count) of the input string.
     *
     * @return minimized JSON string.
     */
    @Override
    public JsonNode read(String json) {
        try {
            return objectMapper.readTree(json);
        } catch (IOException e) {
            throw new IllegalStateException("Wrong JSON format");
        }
    }
}
