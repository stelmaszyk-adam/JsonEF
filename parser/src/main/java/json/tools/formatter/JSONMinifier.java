package json.tools.formatter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
public class JSONMinifier extends JSONFormatter {

    /**
     * Creates a <code>JSONMinimizer</code>
     * and stores its argument, reader, for functionality extension.
     *
     * @param reader the underlying JSON reader.
     */
    public JSONMinifier(JSONReader reader) {
        super(reader);
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
    private String minify(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readValue(json, JsonNode.class);
            return jsonNode.toString();
        } catch (IOException e) {
            throw new IllegalArgumentException("Wrong JSON format");
        }
    }
    @Override
    public String read(String json) {
        json = jsonReader.read(json);
        return minify(json);
    }
}
