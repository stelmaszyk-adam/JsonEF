package json.parser.formatter;

import com.fasterxml.jackson.databind.JsonNode;

public interface  JSONReader {
    JsonNode read(String json);
}
