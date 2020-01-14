package json.tools.formatter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.EnumSet;

/**
 * A <code>JSONInclusiveFormatter</code> includes defined formatting features to another JSON reader.
 * Specifically, it allows an input JSON string to be read
 * and formatted in defined way.
 *
 * @author Vladvance
 * @version 0.1
 * @since 0.1
 */
public class JSONInclusiveFormatter extends JSONFormatter {

    /**
     * instance of ExclusivePrettyPrinter
     */
    private InclusivePrettyPrinter inclusivePrettyPrinter;

    /**
     * Creates a <code>JSONInclusiveFormatter</code>
     * and stores its argument, reader, for functionality extension. Second parameter
     * determines, what features include to output string.
     *
     * @param reader the underlying JSON reader.
     * @param flags flags determining including features
     */
    public JSONInclusiveFormatter(JSONReader reader, EnumSet<FormatterFlags> flags) {
        super(reader);
        inclusivePrettyPrinter = new InclusivePrettyPrinter(flags);
    }

    /**
     * Reads a JSON string and returns version of it with included formatting features.
     *
     * @return formatted JSON string.
     */
    private String format(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readValue(json, JsonNode.class);
            return mapper.writer(inclusivePrettyPrinter).writeValueAsString(jsonNode);

        } catch (IOException e) {
            throw new IllegalArgumentException("Wrong JSON format");
        }
    }

    @Override
    public String read(String json) {
        json = jsonReader.read(json);
        return format(json);
    }

}
